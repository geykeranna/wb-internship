package ru.testtask.testapplication.ui.screens.events.active

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.usecases.event.GetEventListByGroupUseCase

class ActiveEventsScreenViewModel(
    private val getEvents: GetEventListByGroupUseCase
) : ViewModel() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.shimmerData) )
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    fun getData(): StateFlow<List<CommunityData>> = dataList
}