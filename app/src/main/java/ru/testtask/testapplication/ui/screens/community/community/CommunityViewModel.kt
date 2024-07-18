package ru.testtask.testapplication.ui.screens.community.community

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.usecases.community.GetCommunityListUseCase
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel

class CommunityViewModel(
    private val getDataList: GetCommunityListUseCase
) : BaseViewModel<CommunityViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.shimmerData) )
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    fun getData(): StateFlow<List<CommunityData>> = dataList

    private fun startLoading() = viewModelScope.launch {
        _dataList.emit(getDataList.execute())
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val id: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }
}