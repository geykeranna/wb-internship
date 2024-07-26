package ru.wb.ui.ui.screens.events.active

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.usecases.event.GetEventListByGroupUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class ActiveEventsScreenViewModel(
    private val getEventsList: GetEventListByGroupUseCase
) : BaseViewModel<ActiveEventsScreenViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(EventsByGroup.defaultObject))
    private val dataList: StateFlow<List<EventsByGroup>> = _dataList

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getData(): StateFlow<List<EventsByGroup>> = dataList

    private fun startLoading() = viewModelScope.launch {
        _dataList.emit(getEventsList.execute(""))
    }

    private fun fetchData(query: String? = null) = viewModelScope.launch {
        _dataList.emit(getEventsList.execute(query))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnLoadData(val query: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnLoadData -> {
                fetchData(event.query)
            }
        }
    }
}