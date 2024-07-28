package ru.wb.ui.ui.screens.events.myevents

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.usecases.event.GetEventListByGroupUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class MyEventScreenViewModel(
    private val getEvents: GetEventListByGroupUseCase,
    private val getUserId: GetCurrentUserIDUseCase,
) : BaseViewModel<MyEventScreenViewModel.Event>() {
    private val _dataList = MutableStateFlow(listOf(EventsByGroup.defaultObject))
    private val dataList: StateFlow<List<EventsByGroup>> = _dataList

    private val _userID = MutableStateFlow("")
    private val userID: StateFlow<String> = _userID

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getDataListFlow(): StateFlow<List<EventsByGroup>> = dataList

    private fun startLoading() = viewModelScope.launch {
        _userID.emit(getUserId.execute())
        _dataList.emit(getEvents.execute(userId = userID.value))
    }

    private fun fetchData() = viewModelScope.launch {
        _dataList.emit(getEvents.execute(userId = userID.value))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnLoadData : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnLoadData -> {
                fetchData()
            }
        }
    }
}