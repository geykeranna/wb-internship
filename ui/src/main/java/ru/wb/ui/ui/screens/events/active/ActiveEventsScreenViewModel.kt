package ru.wb.ui.ui.screens.events.active

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class ActiveEventsScreenViewModel(
    private val getEventsList: GetEventListUseCase
) : BaseViewModel<ActiveEventsScreenViewModel.Event>() {
    private val _allDataList = MutableStateFlow(listOf<EventData>())
    private val allDataList: StateFlow<List<EventData>> = _allDataList

    private val _activeDataList = MutableStateFlow(listOf<EventData>())
    private val activeDataList: StateFlow<List<EventData>> = _activeDataList

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getAllDataFlow(): StateFlow<List<EventData>> = allDataList

    fun getActiveDataFlow(): StateFlow<List<EventData>> = activeDataList

    private fun startLoading() = viewModelScope.launch {
        getEventsList.execute().collect{
            _allDataList.emit(it)
        }
        getEventsList.execute(state = "active").collect{
            _activeDataList.emit(it)
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