package ru.wb.testapplication.ui.screens.events.myevents

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.usecases.event.GetEventListByGroupUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.testapplication.ui.base.BaseEvent
import ru.wb.testapplication.ui.base.BaseViewModel

class MyEventScreenViewModel(
    private val getEvents: GetEventListByGroupUseCase,
    private val getUserId: GetCurrentUserIDUseCase,
) : BaseViewModel<MyEventScreenViewModel.Event>() {
    private val _dataList = MutableStateFlow(EventsByGroup.defaultObject)
    private val dataList: StateFlow<List<EventsByGroup>> = _dataList

    private val _userID = MutableStateFlow("")
    private val userID: StateFlow<String> = _userID

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getDataList(): StateFlow<List<EventsByGroup>> = dataList

    private fun startLoading() = viewModelScope.launch {
        _userID.value = getUserId.execute()
        _dataList.emit(getEvents.execute(query = "", userId = userID.value))
    }

    private fun fetchData(query: String? = null) = viewModelScope.launch {
        _dataList.emit(getEvents.execute(query, userId = userID.value))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        class OnLoadData(val query: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnLoadData -> {
                fetchData(event.query)
            }
        }
    }
}