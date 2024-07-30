package ru.wb.ui.ui.screens.events.myevents

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.EventData
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class MyEventScreenViewModel(
    private val getEvents: GetEventListUseCase,
    private val getUserId: GetCurrentUserIDUseCase,
) : BaseViewModel<MyEventScreenViewModel.Event>() {
    private val _expectedDataList = MutableStateFlow(listOf(EventData.defaultObject))
    private val expectedDataList: StateFlow<List<EventData>> = _expectedDataList

    private val _passedDataList = MutableStateFlow(listOf(EventData.defaultObject))
    private val passedDataList: StateFlow<List<EventData>> = _passedDataList

    private val _userID = MutableStateFlow("")
    private val userID: StateFlow<String> = _userID

    init {
        obtainEvent(Event.OnLoadingStarted)
    }

    fun getExpectedDataListFlow(): StateFlow<List<EventData>> = expectedDataList

    fun getPassedDataListFlow(): StateFlow<List<EventData>> = passedDataList

    private fun startLoading() = viewModelScope.launch {
        getUserId.execute().collect { _userID.emit(it) }
        val date = ""
        getEvents.execute(userId = userID.value, startDate = date).collect {
            _expectedDataList.emit(it)
        }
        getEvents.execute(userId = userID.value, endDate = date).collect {
            _passedDataList.emit(it)
        }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
        }
    }
}