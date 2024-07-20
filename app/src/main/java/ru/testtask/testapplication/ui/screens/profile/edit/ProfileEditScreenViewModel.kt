package ru.testtask.testapplication.ui.screens.profile.edit

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.testapplication.domain.usecases.login.GetCurrentUserIDUseCase
import ru.testtask.testapplication.domain.usecases.user.GetUserDataUseCase
import ru.testtask.testapplication.domain.usecases.user.SetUserDataUseCase
import ru.testtask.testapplication.repository.data.model.UserData
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel
import ru.testtask.testapplication.ui.screens.profile.components.FormField

class ProfileEditScreenViewModel(
    private val getUserData: GetUserDataUseCase,
    private val setUserData: SetUserDataUseCase,
    private val getUserID: GetCurrentUserIDUseCase,
): BaseViewModel<ProfileEditScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.shimmerData)
    private val userData: StateFlow<UserData> = _userData

    val formFields = mutableListOf(
        FormField(
            id = 0,
            name = "first_name",
            placeholder = "Имя (обязательно)",
            required = true,
            value = userData.value.firstName
        ),
        FormField(
            id = 1,
            name = "last_name",
            placeholder = "Фамилия (опционально)",
            required = false,
            value = userData.value.firstName
        ),
    )

    fun getState(): Boolean {
        return !formFields
            .filter { it.required }
            .all { it.value.isNotEmpty() }
    }

    private fun sendData() = viewModelScope.launch {
        _userData.value.firstName = formFields[0].value
        _userData.value.lastName = formFields[1].value
        setUserData.execute(userData.value)
    }

    private fun startLoading() = viewModelScope.launch {
        _userData.value.id = getUserID.execute()
        _userData.emit(getUserData.execute(id = _userData.value.id))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnSetData : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnSetData -> {
                sendData()
            }
        }
    }
}