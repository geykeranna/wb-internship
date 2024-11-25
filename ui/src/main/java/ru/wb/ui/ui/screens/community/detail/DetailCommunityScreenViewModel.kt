package ru.wb.ui.ui.screens.community.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.domain.usecases.user.GetSubscriptionCommunityStatusUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.community.detail.components.ButtonsStateSub

internal class DetailCommunityScreenViewModel(
    idCommunity: String,
    private val getData: GetCommunityDataUseCase,
    private val getStateSubscribe: GetSubscriptionCommunityStatusUseCase,
) : BaseViewModel<DetailCommunityScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(CommunityData.defaultObject)
    private val detailData: StateFlow<CommunityData> = _detailData

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    private val _btnState = MutableStateFlow(ButtonsStateSub.DEFAULT)
    private val btnState: StateFlow<ButtonsStateSub> = _btnState

    init {
        obtainEvent(Event.OnLoadingStarted(idCommunity))
    }

    fun getDetailDataFlow(): StateFlow<CommunityData> = detailData

    fun getBtnStateBySubStatusFlow(): StateFlow<ButtonsStateSub> = btnState

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading(id: String) = viewModelScope.launch {
        getData.execute(id).collect { data ->
            when(data) {
                is LoadState.Empty -> _state.emit(BaseState.EMPTY)
                is LoadState.Error -> _state.emit(BaseState.ERROR)
                is LoadState.Loading -> _state.emit(BaseState.LOADING)
                is LoadState.Success -> {
                    _detailData.emit(data.data)
                    when {
                        data.data.id.isEmpty() -> _state.emit(BaseState.ERROR)
                        else -> _state.emit(BaseState.SUCCESS)
                    }
                }
            }
        }
        getStateSubscribe.execute(idCommunity = id).collect { result ->
            when(result) {
                is LoadState.Empty -> _state.emit(BaseState.EMPTY)
                is LoadState.Error -> _state.emit(BaseState.ERROR)
                is LoadState.Loading -> _state.emit(BaseState.LOADING)
                is LoadState.Success -> {
                    when {
                        result.data == UserSubscribeStatusResponse.SUBSCRIBED ->
                            _btnState.emit(ButtonsStateSub.PRESSED)
                        else -> _btnState.emit(ButtonsStateSub.UNPRESSED)
                    }
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    private fun onChangeSubscribeStatus() = viewModelScope.launch {
        when (btnState.value) {
            ButtonsStateSub.PRESSED -> _btnState.emit(ButtonsStateSub.UNPRESSED)
            else ->  _btnState.emit(ButtonsStateSub.PRESSED)
        }
    }

    sealed class Event : BaseEvent() {
        data object OnChangeSubscribeStatus : Event()
        class OnLoadingStarted(val id: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(id = event.id)
            }
            is Event.OnChangeSubscribeStatus -> {
                onChangeSubscribeStatus()
            }
        }
    }
}