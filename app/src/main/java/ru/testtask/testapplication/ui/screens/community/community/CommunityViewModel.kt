package ru.testtask.testapplication.ui.screens.community.community

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.usecases.community.GetCommunityListUseCase

class CommunityViewModel(
    private val getDataList: GetCommunityListUseCase
) : ViewModel() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.shimmerData) )
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    fun getData(): StateFlow<List<CommunityData>> = dataList
}