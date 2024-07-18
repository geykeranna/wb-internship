package ru.testtask.testapplication.ui.screens.community.community

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.testtask.testapplication.repository.data.model.CommunityData
import ru.testtask.testapplication.domain.usecases.community.GetCommunityListUseCase
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel
import ru.testtask.testapplication.ui.component.utils.Constants.SEARCH_WAITING_TIME

class CommunityViewModel(
    private val getDataList: GetCommunityListUseCase,
) : BaseViewModel<CommunityViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(CommunityData.shimmerData))
    private val dataList: StateFlow<List<CommunityData>> = _dataList

    private val _searchText = MutableStateFlow("")
    private val searchText: StateFlow<String> = _searchText

    private val _isSearching = MutableStateFlow(false)
    private val isSearching: StateFlow<Boolean> = _isSearching

    fun getDataFlow(): StateFlow<List<CommunityData>> = dataList

    fun getSearchState(): StateFlow<Boolean> = isSearching

    fun getSearchText(): StateFlow<String> = searchText

    fun getData(): StateFlow<List<CommunityData>> = searchText
        .combine(dataList) { query, community ->
            when (query) {
                "" -> community
                else -> community.filter {
                    it.doesMatchSearchQuery(query = query)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(SEARCH_WAITING_TIME),
            dataList.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    private fun startLoading() = viewModelScope.launch {
        // TODO
        _dataList.emit(getDataList.execute(""))
    }

    private fun fetchData(query: String? = null) = viewModelScope.launch {
        _dataList.emit(getDataList.execute(query))
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val id: String) : Event()
        class OnChangeParams(val query: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnChangeParams -> {
                fetchData(event.query)
            }
        }
    }
}