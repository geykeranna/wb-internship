package ru.wb.testapplication.ui.screens.community.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.testapplication.ui.base.BaseEvent
import ru.wb.testapplication.ui.base.BaseViewModel

class DetailCommunityScreenViewModel(
    idCommunity: String,
    private val getData: GetCommunityDataUseCase
) : BaseViewModel<DetailCommunityScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(CommunityData.defaultObject)
    private val detailData: StateFlow<CommunityData> = _detailData

    init {
        obtainEvent(Event.OnLoadingStarted(idCommunity))
    }

    fun getDetailData(): StateFlow<CommunityData> = detailData

    private fun startLoading(id: String) = viewModelScope.launch {
        _detailData.emit(getData.execute(id))
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