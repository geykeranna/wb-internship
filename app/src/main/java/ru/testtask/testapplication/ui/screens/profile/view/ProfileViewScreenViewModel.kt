package ru.testtask.testapplication.ui.screens.profile.view

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.testapplication.domain.usecases.user.GetUserDataUseCase
import ru.testtask.testapplication.repository.data.model.UserData
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel

class ProfileViewScreenViewModel(
    private val getUserData: GetUserDataUseCase
): BaseViewModel<ProfileViewScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.shimmerData)
    private val userData: StateFlow<UserData> = _userData

    fun getUser(): StateFlow<UserData> = userData

    private fun startLoading() = viewModelScope.launch {
        _userData.emit(getUserData.execute(id = _userData.value.id))
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