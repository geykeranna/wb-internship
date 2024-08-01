package ru.wb.ui.ui.screens.events.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.user.HandleGoingEventUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
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

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted(idEvent))
    }

    fun getDetailDataFlow(): StateFlow<EventData> = detailData

    fun getBntStateFlow(): StateFlow<String> = bntState

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading(id: String) = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getData.execute(id).collect {
            when {
                it.id.isEmpty() -> _state.emit(BaseState.ERROR)
                else -> {
                    _detailData.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    private fun onChangeEventStatus(idEvent: String) = viewModelScope.launch {
        handleEvent.execute(eventId = idEvent)
        when (_btnState.value) {
            ButtonState.PRESSED.id -> {
                _btnState.emit(ButtonState.UNPRESSED.id)
                _detailData.emit(detailData.value.copy(usersList = detailData.value.usersList.dropLast(1)))
            }
            else -> {
                _btnState.emit(ButtonState.UNPRESSED.id)
                getData.execute(idEvent).collect{
                    _detailData.emit(it)
                }
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
                onChangeEventStatus(idEvent = event.id)
            }
        }
    }
}