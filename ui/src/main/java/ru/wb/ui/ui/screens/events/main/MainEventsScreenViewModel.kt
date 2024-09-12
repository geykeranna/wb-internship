package ru.wb.ui.ui.screens.events.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.ContentItems
import ru.wb.domain.usecases.common.GetContentUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionCommunityStatusUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.defaultChipsList

internal class MainEventsScreenViewModel(
    private val getContent: GetContentUseCase,
    private val changeSubscribeState: ChangeSubscriptionCommunityStatusUseCase,
) : BaseViewModel<MainEventsScreenViewModel.Event>() {
    private val lastChipsActionItem = "Все категории"

    private val _content = MutableStateFlow<List<ContentItems>>(listOf())
    private val content: StateFlow<List<ContentItems>> = _content

    private val _labelContent = MutableStateFlow<List<ContentItems>>(listOf())
    private val labelContent: StateFlow<List<ContentItems>> = _labelContent

    private val _selectedItems = MutableStateFlow(listOf(lastChipsActionItem))
    private val selectedItems: StateFlow<List<String>> = _selectedItems

    private val _searchString = MutableStateFlow("")
    private val searchString: StateFlow<String> = _searchString

    private val _stateContent = MutableStateFlow(BaseState.EMPTY)
    private val stateContent: StateFlow<BaseState> = _stateContent

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getContentDataFlow(): StateFlow<List<ContentItems>> = content

    fun getLabelContentDataFlow(): StateFlow<List<ContentItems>> = labelContent

    fun getSearchStringFlow(): StateFlow<String> = searchString

    fun getContentStateFlow(): StateFlow<BaseState> = stateContent

    fun getChipsFlow(): StateFlow<List<String>> = selectedItems

    fun getAllChipsList(): List<String> = defaultChipsList + lastChipsActionItem

    private fun startFetchData() = viewModelScope.launch {
        _stateContent.emit(BaseState.LOADING)
        getContent.execute().collect { newValue ->
            if(newValue.items.isEmpty()) {
                _stateContent.emit(BaseState.EMPTY)
                return@collect
            }
            val (labeledData, filteredData) = newValue.items.partition { it.isStatic }
            _labelContent.emit(labeledData)
            _content.emit(filteredData)
            _stateContent.emit(BaseState.SUCCESS)
        }
    }

    private fun fetchData() = viewModelScope.launch {
        _stateContent.emit(BaseState.LOADING)
        getContent.execute(
            search = searchString.value,
            filter = selectedItems.value,
        ).collect { newValue ->
            if(newValue.items.isEmpty()){
                _stateContent.emit(BaseState.EMPTY)
                return@collect
            }
            _content.emit(newValue.items)
            _stateContent.emit(BaseState.SUCCESS)
        }
    }

    private fun onSearch(search: String) = viewModelScope.launch {
        _searchString.emit(search)
        fetchData()
    }

    private fun onSelectItems(selectedItem: String) = viewModelScope.launch {
        var mutableList = selectedItems.value.toMutableList()

        when {
            selectedItem == lastChipsActionItem -> { mutableList = mutableListOf(lastChipsActionItem) }
            selectedItems.value.contains(selectedItem) -> {
                mutableList.remove(selectedItem)
                if (mutableList.isEmpty()) mutableList.add(lastChipsActionItem)
            }
            else -> {
                mutableList.remove(lastChipsActionItem)
                mutableList.add(selectedItem)
            }
        }
        _selectedItems.emit(mutableList.toList())
        fetchData()
    }

    private fun onChangeSub(idCommunity: String, idContentItem: String) = viewModelScope.launch {
        changeSubscribeState.execute(idCommunity).collect { results ->
            val newValue = content.value.map { item ->
                if (item.id == idContentItem) {
                    item.copy(communityList = item.communityList?.map { value ->
                        if (value.id == idCommunity) { value.copy(isSubscribed = results) }
                        else { value }
                    })
                } else item
            }
            _content.emit(newValue)
        }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnSearch(val query: String) : Event()
        class OnSelectValue(val selectedList: String): Event()
        class OnChangeSubscribeState(val idCommunity: String, val idContentItem: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startFetchData()
            }
            is Event.OnSearch -> {
                onSearch(event.query)
            }
            is Event.OnSelectValue -> {
                onSelectItems(event.selectedList)
            }
            is Event.OnChangeSubscribeState -> {
                onChangeSub(event.idCommunity, event.idContentItem)
            }
        }
    }
}