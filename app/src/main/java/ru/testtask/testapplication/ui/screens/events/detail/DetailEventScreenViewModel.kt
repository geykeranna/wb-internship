package ru.testtask.testapplication.ui.screens.events.detail

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.domain.usecases.event.GetEventDataUseCase
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel

class DetailEventScreenViewModel(
    idEvent: String,
    private val getData: GetEventDataUseCase
) : BaseViewModel<DetailEventScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(EventData.shimmerData1)
    private val detailData: StateFlow<EventData> = _detailData

    init {
        obtainEvent(Event.OnLoadingStarted(idEvent))
    }

    fun getDetailData(): StateFlow<EventData> = detailData

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