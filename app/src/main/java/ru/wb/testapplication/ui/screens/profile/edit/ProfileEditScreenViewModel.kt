package ru.wb.testapplication.ui.screens.profile.edit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.SetUserDataUseCase
import ru.wb.testapplication.ui.base.BaseEvent
import ru.wb.testapplication.ui.base.BaseViewModel
import ru.wb.testapplication.ui.screens.profile.components.FormField

class ProfileEditScreenViewModel(
    private val getUserData: GetUserDataUseCase,
    private val setUserData: SetUserDataUseCase,
    private val getUserID: GetCurrentUserIDUseCase,
): BaseViewModel<ProfileEditScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.defaultObject)
    private val userData: StateFlow<UserData> = _userData

    val formFields = mutableListOf(
        FormField(
            id = 0,
            name = "first_name",
            placeholder = "Имя (обязательно)",
            required = true,
            inputValue = mutableStateOf(userData.value.firstName)
        ),
        FormField(
            id = 1,
            name = "last_name",
            placeholder = "Фамилия (опционально)",
            required = false,
            inputValue = mutableStateOf(userData.value.firstName)
        ),
    )

    fun getState(): Boolean {
        return formFields
            .filter { it.required }
            .all { it.inputValue.value.isNotEmpty() }
    }

    fun setFieldData(index: Int, input: String) {
        formFields[index].inputValue.value = input
    }

    private fun sendData() = viewModelScope.launch {
        _userData.value.firstName = formFields[0].inputValue.value
        _userData.value.lastName = formFields[1].inputValue.value
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