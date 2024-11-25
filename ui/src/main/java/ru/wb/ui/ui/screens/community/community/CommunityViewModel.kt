package ru.wb.ui.ui.screens.community.community

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class CommunityViewModel(
    private val getDataList: GetCommunityListUseCase,
) : BaseViewModel<CommunityViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.defaultObject))
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    private val _searchText = MutableStateFlow("")
    private val searchText: StateFlow<String> = _searchText

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getSearchTextFlow(): StateFlow<String> = searchText

    fun getDataFlow(): StateFlow<List<CommunityData>> = dataList

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun onSearchTextChange(text: String) = viewModelScope.launch {
        _searchText.emit(text)
    }

    private fun fetchData(
        query: String? = null,
    ) = viewModelScope.launch {
        getDataList.execute(query = query).collect{ data ->
            when(data) {
                is LoadState.Empty -> _state.emit(BaseState.EMPTY)
                is LoadState.Error -> _state.emit(BaseState.ERROR)
                is LoadState.Loading -> _state.emit(BaseState.LOADING)
                is LoadState.Success -> {
                    _dataList.emit(data.data.data)
                    when {
                        data.data.data.isEmpty() ->  _state.emit(BaseState.EMPTY)
                        else -> _state.emit(BaseState.SUCCESS)
                    }
                }
            }
        }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnLoadData(val query: String) : Event()
        class OnInputSearchField(val value: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                fetchData()
            }
            is Event.OnLoadData -> {
                fetchData(event.query)
            }
            is Event.OnInputSearchField -> {
                onSearchTextChange(event.value)
            }
        }
    }
}