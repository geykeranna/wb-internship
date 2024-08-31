package ru.wb.ui.ui.screens.users.list

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.user.GetUserListUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel

internal class UsersListScreenViewModel(
    data: String,
    private val getData: GetUserListUseCase,
) : BaseViewModel<UsersListScreenViewModel.Event>() {
    private val _detailData = MutableStateFlow(listOf(UserData.defaultObject))
    private val detailData: StateFlow<List<UserData>> = _detailData

    private val _state = MutableStateFlow(BaseState.EMPTY)
    private val state: StateFlow<BaseState> = _state

    private val _userListLabels = MutableStateFlow(UsersListLabel.EMPTY)
    private val userListLabels: StateFlow<UsersListLabel> = _userListLabels

    init {
        obtainEvent(Event.OnLoadingStarted(data))
    }

    fun getDataListFlow(): StateFlow<List<UserData>> = detailData

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getUserListLabelFlow(): StateFlow<UsersListLabel> = userListLabels

    private fun startLoading(data: String) = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        val (source, id) = data.split(" ")
        var apiCall: Flow<List<UserData>>? = null
        when (source) {
            "event" -> {
                _userListLabels.emit(UsersListLabel.EVENT)
                apiCall = getData.execute(eventId = id)
            }
            "community" -> {
                _userListLabels.emit(UsersListLabel.COMMUNITY)
                apiCall = getData.execute(communityId = id)
            }
        }
        apiCall?.let { response ->
            response.collect {
                when {
                    it.isEmpty() -> _state.emit(BaseState.EMPTY)
                    else -> {
                        _detailData.emit(it)
                        _state.emit(BaseState.SUCCESS)
                    }
                }
            }
        }
    }

    sealed class Event : BaseEvent() {
        class OnLoadingStarted(val data: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading(data = event.data)
            }
        }
    }
}