package ru.testtask.testapplication.ui.screens.community.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.usecases.community.GetCommunityDataUseCase

class DetailCommunityScreenViewModel(
    private val getData: GetCommunityDataUseCase
) : ViewModel() {
    private val _detailData = MutableStateFlow(CommunityData.shimmerData)
    private val detailData: StateFlow<CommunityData> = _detailData

    fun getDetailData(): StateFlow<CommunityData> = detailData
}