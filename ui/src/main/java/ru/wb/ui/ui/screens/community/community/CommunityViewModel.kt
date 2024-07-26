package ru.wb.ui.ui.screens.community.community

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class CommunityViewModel(
    private val getDataList: GetCommunityListUseCase,
) : BaseViewModel<CommunityViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.defaultObject))
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    private val _searchText = MutableStateFlow("")
    private val searchText: StateFlow<String> = _searchText

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getSearchText(): StateFlow<String> = searchText

    fun getData(): StateFlow<List<CommunityData>> = dataList

    private fun startLoading() = viewModelScope.launch {
        _dataList.emit(getDataList.execute())
    }

    private fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    private fun fetchData(
        query: String? = null,
    ) = viewModelScope.launch {
        _dataList.emit(getDataList.execute(CommunitiesGetRequest(query = query)))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnLoadData(val query: String) : Event()
        class OnInputSearchField(val value: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnLoadData -> {
                fetchData(event.query)
            }
            is Event.OnInputSearchField -> {
                onSearchTextChange(event.value)
            }
        }
    }
}