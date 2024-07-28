package ru.wb.ui.ui.screens.events.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.user.HandleGoingEventUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.events.components.ButtonState

internal class DetailEventScreenViewModel(
    idEvent: String,
    private val getData: GetEventDataUseCase,
    private val handleEvent: HandleGoingEventUseCase,
) : BaseViewModel<DetailEventScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(EventData.defaultObject)
    private val detailData: StateFlow<EventData> = _detailData

    private val _btnState = MutableStateFlow(ButtonState.DEFAULT.id)
    private val bntState: StateFlow<String> = _btnState

    init {
        obtainEvent(Event.OnLoadingStarted(idEvent))
    }

    fun getDetailDataFlow(): StateFlow<EventData> = detailData

    fun getBntStateFlow(): StateFlow<String> = bntState

    private fun startLoading(id: String) = viewModelScope.launch {
        _detailData.emit(getData.execute(id))
    }

    private fun onHandleEvent(idEvent: String) = viewModelScope.launch {
        handleEvent.execute(eventId = idEvent)
        when (_btnState.value) {
            ButtonState.PRESSED.id -> {
                _btnState.emit(ButtonState.UNPRESSED.id)
                _detailData.emit(detailData.value.copy(usersList = detailData.value.usersList.dropLast(1)))
            }
            else -> {
                _btnState.emit(ButtonState.UNPRESSED.id)
                _detailData.emit(getData.execute(idEvent))
            }
        }
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val id: String) : Event()
        class OnHandleGoingEvent(val id: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(id = event.id)
            }
            is Event.OnHandleGoingEvent -> {
                onHandleEvent(idEvent = event.id)
            }
        }
    }
}