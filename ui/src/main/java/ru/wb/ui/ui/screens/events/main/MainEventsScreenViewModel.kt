package ru.wb.ui.ui.screens.events.main

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.chips.ChipsData

internal class MainEventsScreenViewModel(
    private val getEventsList: GetEventListUseCase,
    private val getCommunityList: GetCommunityListUseCase,
) : BaseViewModel<MainEventsScreenViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf<EventData>())
    private val dataList: StateFlow<List<EventData>> = _dataList

    private val _dataListCommunity = MutableStateFlow(listOf(CommunityData.defaultObject))
    private val dataListCommunity: StateFlow<List<CommunityData>> = _dataListCommunity

    private val _chipsData = MutableStateFlow(listOf(ChipsData(id="0", name = "Все категории")))
    private val chipsData: StateFlow<List<ChipsData>> = _chipsData

    private val _searchString = MutableStateFlow("")
    private val searchString: StateFlow<String> = _searchString

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getAllDataFlow(): StateFlow<List<EventData>> = dataList

    fun getSearchStringFlow(): StateFlow<String> = searchString

    fun getDataCommunityFlow(): StateFlow<List<CommunityData>> = dataListCommunity

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getChipsFlow(): StateFlow<List<ChipsData>> = chipsData

    fun getAllChipsList(): List<ChipsData> = listOf(
        ChipsData(id = "key", name = "Дизайн"),
        ChipsData(id = "key", name = "Разработка"),
        ChipsData(id = "key", name = "Продакт менеджмент"),
        ChipsData(id = "key", name = "Backend"),
        ChipsData(id = "key", name = "Frontend"),
        ChipsData(id = "key", name = "Mobile"),
        ChipsData(id = "key", name = "Web"),
        ChipsData(id = "key", name = "Тестирование"),
        ChipsData(id = "key", name = "Продажи"),
        ChipsData(id = "key", name = "Бизнес"),
        ChipsData(id = "key", name = "Маркетинг"),
        ChipsData(id = "key", name = "Безопасность"),
        ChipsData(id = "key", name = "Девопс"),
        ChipsData(id = "key", name = "Аналитика"),
        ChipsData(id = "all", name = "Все категории"),
    )

    private fun startLoading() = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getEventsList.execute().collect {
            when {
                it.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _dataList.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
        getCommunityList.execute().collect {
            when {
                it.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _dataListCommunity.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    private fun onSearch(search: String) = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        _searchString.emit(search)
        getEventsList.execute(query = search).collect {
            when {
                it.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _dataList.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    private fun onSelectItems(selectedList: List<ChipsData>) = viewModelScope.launch {
        _chipsData.emit(selectedList)
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnSearch(val query: String) : Event()
        class OnSelectValue(val selectedList: List<ChipsData>): Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnSearch -> {
                onSearch(event.query)
            }
            is Event.OnSelectValue -> {
                onSelectItems(event.selectedList)
            }
        }
    }
}