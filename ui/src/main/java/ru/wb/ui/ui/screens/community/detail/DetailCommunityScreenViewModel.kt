package ru.wb.ui.ui.screens.community.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class DetailCommunityScreenViewModel(
    idCommunity: String,
    private val getData: GetCommunityDataUseCase
) : BaseViewModel<DetailCommunityScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(CommunityData.defaultObject)
    private val detailData: StateFlow<CommunityData> = _detailData

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    init {
        obtainEvent(Event.OnLoadingStarted(idCommunity))
    }

    fun getDetailDataFlow(): StateFlow<CommunityData> = detailData

    fun getStateFlow(): StateFlow<BaseState> = state

    private fun startLoading(id: String) = viewModelScope.launch {
        getData.execute(id).collect{
            when {
                it.id.isEmpty() -> _state.emit(BaseState.ERROR)
                else -> {
                    _detailData.emit(it)
                    _state.emit(BaseState.SUCCESS)
                }
            }
        }
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val id: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(id = event.id)
            }
        }
    }
}