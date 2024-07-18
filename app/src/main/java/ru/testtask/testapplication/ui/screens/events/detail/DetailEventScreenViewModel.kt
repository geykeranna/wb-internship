package ru.testtask.testapplication.ui.screens.events.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.domain.usecases.event.GetEventDataUseCase

class DetailEventScreenViewModel(
    private val getData: GetEventDataUseCase
) : ViewModel() {
    private val _detailData = MutableStateFlow(EventData.shimmerData1)
    private val detailData: StateFlow<EventData> = _detailData

    fun getDetailData(): StateFlow<EventData> = detailData
}