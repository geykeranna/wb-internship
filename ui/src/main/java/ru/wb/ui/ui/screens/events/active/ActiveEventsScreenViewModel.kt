package ru.wb.ui.ui.screens.events.active

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class ActiveEventsScreenViewModel(
    private val getEventsList: GetEventListUseCase
) : BaseViewModel<ActiveEventsScreenViewModel.Event>() {
    private val _allDataList = MutableStateFlow(listOf<EventData>())
    private val allDataList: StateFlow<List<EventData>> = _allDataList

    private val _activeDataList = MutableStateFlow(listOf<EventData>())
    private val activeDataList: StateFlow<List<EventData>> = _activeDataList

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getAllDataFlow(): StateFlow<List<EventData>> = allDataList

    fun getActiveDataFlow(): StateFlow<List<EventData>> = activeDataList

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading() = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getEventsList.execute().collect{
            when {
                it.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _allDataList.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
        getEventsList.execute(state = "active").collect{
            when {
                it.isEmpty() -> _state.emit(BaseState.EMPTY)
                else -> {
                    _activeDataList.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }
}