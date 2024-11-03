package ru.wb.ui.ui.screens.auth.onevent.name

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel

internal class AppointmentNameViewModel(
    private val setUserData: PostUserDataUseCase,
) : BaseViewModel<AppointmentNameViewModel.Event>() {
    private val _inputValue = MutableStateFlow("")
    private val inputValue: StateFlow<String> = _inputValue

    private val _validation = MutableStateFlow(false)
    private val validation: StateFlow<Boolean> = _validation

    fun getValidationFlow(): StateFlow<Boolean> = validation

    fun getInput(): StateFlow<String> = inputValue

    private fun onChangeValue(newValue: String) = viewModelScope.launch {
        _inputValue.emit(newValue)
        _validation.emit(inputValue.value.isNotEmpty())
    }

    private fun setNameUser() = viewModelScope.launch {
        setUserData.setName(inputValue.value)
    }

    sealed class Event : BaseEvent() {
        data object OnEnterClick : Event()
        class OnChangeValue(val inputValue: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnEnterClick -> {
                setNameUser()
            }
            is Event.OnChangeValue -> {
                onChangeValue(newValue = event.inputValue)
            }
        }
    }
}