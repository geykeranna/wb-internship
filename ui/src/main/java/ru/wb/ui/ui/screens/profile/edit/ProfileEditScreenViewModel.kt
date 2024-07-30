package ru.wb.ui.ui.screens.profile.edit

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.profile.components.ScreenState

internal class ProfileEditScreenViewModel(
    private val getUserData: GetUserDataUseCase,
    private val setUserData: PostUserDataUseCase,
    private val getUserID: GetCurrentUserIDUseCase,
): BaseViewModel<ProfileEditScreenViewModel.Event>() {
    private val _userData = MutableStateFlow(UserData.defaultObject)
    private val userData: StateFlow<UserData> = _userData

    private val formFieldsValue = MutableStateFlow(
        ScreenState(
            firstName = userData.value.firstName,
            lastName = userData.value.lastName.orEmpty(),
        )
    )

    fun getFieldsValuesFlow(): MutableStateFlow<ScreenState> = formFieldsValue

    fun getState(): Boolean {
        return formFieldsValue.value.firstName.isNotEmpty()
    }

    private fun setFieldData(key: Int, input: String) {
        when (key) {
            0 -> formFieldsValue.value = formFieldsValue.value.copy(firstName = input)
            1 -> formFieldsValue.value = formFieldsValue.value.copy(lastName = input)
        }
    }

    private fun sendData() = viewModelScope.launch {
        _userData.value.firstName = formFieldsValue.value.firstName
        _userData.value.lastName = formFieldsValue.value.lastName
        setUserData.execute(userData.value)
    }

    private fun startLoading() = viewModelScope.launch {
        getUserID.execute().collect { _userData.value.id = it }
        getUserData.execute(id = _userData.value.id).collect{ _userData.emit(it) }
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnSetData : Event()
        class OnChangeFieldData(val key: Int, val input: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnSetData -> {
                sendData()
            }
            is Event.OnChangeFieldData -> {
                setFieldData(
                    key = event.key,
                    input = event.input
                )
            }
        }
    }
}