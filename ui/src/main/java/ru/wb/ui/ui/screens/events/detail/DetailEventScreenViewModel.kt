package ru.wb.ui.ui.screens.events.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionEventStatusUseCase
import ru.wb.domain.usecases.user.GetSubscriptionEventStatusUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.events.detail.components.ButtonState

internal class DetailEventScreenViewModel(
    idEvent: String,
    private val getData: GetEventDataUseCase,
    private val getUser: GetUserDataUseCase,
    private val getStatusSubscribe: GetSubscriptionEventStatusUseCase,
    private val handleEvent: ChangeSubscriptionEventStatusUseCase,
) : BaseViewModel<DetailEventScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(EventData.defaultObject)
    private val detailData: StateFlow<EventData> = _detailData

    private val _btnState = MutableStateFlow(ButtonState.DEFAULT.id)
    private val bntState: StateFlow<String> = _btnState

    private val _authStatus = MutableStateFlow("")
    private val authStatus: StateFlow<String> = _authStatus

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted(idEvent))
    }

    fun getDetailDataFlow(): StateFlow<EventData> = detailData

    fun getBntStateFlow(): StateFlow<String> = bntState

    fun getAuthStatusFlow(): StateFlow<String> = authStatus

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading(id: String) = viewModelScope.launch {
        getData.execute(id = id).collect { state ->
            when(state) {
                is LoadState.Empty -> _state.emit(BaseState.EMPTY)
                is LoadState.Loading -> _state.emit(BaseState.LOADING)
                is LoadState.Error -> _state.emit(BaseState.ERROR)
                is LoadState.Success -> when{
                    state.data.id.isEmpty() -> _state.emit(BaseState.ERROR)
                    else -> {
                        _detailData.emit(state.data)
                        _state.emit(BaseState.SUCCESS)
                    }
                }
            }
        }
        getStatusSubscribe.execute(idEvent = id).collect{ status ->
            when(status) {
                is LoadState.Loading -> _btnState.emit(ButtonState.DEFAULT.id)
                is LoadState.Error -> _btnState.emit(ButtonState.DEFAULT.id)
                is LoadState.Success ->  when (status.data) {
                    UserSubscribeStatusResponse.SUBSCRIBED -> _btnState.emit(ButtonState.PRESSED.id)
                    UserSubscribeStatusResponse.NOT_SUBSCRIBED -> _btnState.emit(ButtonState.UNPRESSED.id)
                }
                else -> {}
            }
        }
        getUser.execute().collect{ result ->
            when(result) {
                is LoadState.Success -> _authStatus.emit(result.data.id)
                else -> {}
            }
        }
    }

    private fun onChangeEventStatus(idEvent: String) = viewModelScope.launch {
        handleEvent.execute(eventId = idEvent).collect { state ->
            when(state){
                is LoadState.Success -> {
                    when(state.data){
                        UserSubscribeStatusResponse.SUBSCRIBED -> _btnState.emit(ButtonState.PRESSED.id)
                        UserSubscribeStatusResponse.NOT_SUBSCRIBED -> _btnState.emit(ButtonState.UNPRESSED.id)
                    }
                }
                else -> {}
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