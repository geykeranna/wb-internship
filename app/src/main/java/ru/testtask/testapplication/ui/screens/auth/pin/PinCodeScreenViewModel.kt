package ru.testtask.testapplication.ui.screens.auth.pin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.testtask.testapplication.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.testtask.testapplication.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.testtask.testapplication.domain.usecases.login.SendPinCodeUseCase
import ru.testtask.testapplication.ui.base.BaseEvent
import ru.testtask.testapplication.ui.base.BaseViewModel
import ru.testtask.testapplication.ui.component.utils.Constants.PASS_LENGTH_IN_PASS_FIELD

class PinCodeScreenViewModel(
    private val getPhone: GetCurrentPhoneNumberUseCase,
    private val sendPhone: SendPinCodeOnPhoneUseCase,
    private val sendPin: SendPinCodeUseCase,
) : BaseViewModel<PinCodeScreenViewModel.Event>() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber

    private val _pin = MutableStateFlow("")
    private val pin: StateFlow<String> = _pin

    fun getPhoneNumber(): StateFlow<String> = phoneNumber

    fun getPinValue(): StateFlow<String> = pin

    fun sendPinAgain() = obtainEvent(Event.OnSendAgain)

    fun onChangePin(pin: String) = obtainEvent(Event.OnInputPin(pin = pin))

    fun getValidateState(): Boolean {
        return pin.value.length == PASS_LENGTH_IN_PASS_FIELD
    }

    private fun startLoading() = viewModelScope.launch {
        _phoneNumber.value = getPhone.execute()
    }

    private fun sendPin() = viewModelScope.launch {
        sendPin.execute(pin = pin.value)
        _pin.value = ""
    }

    private fun sendOnPhone() = viewModelScope.launch {
        sendPhone.execute(phone = phoneNumber.value)
        _pin.value = ""
    }

    private fun setPin(pin: String) {
        _pin.value = pin
    }

    sealed class Event : BaseEvent() {
        data object OnLoadingStarted : Event()
        data object OnSendAgain : Event()
        data object OnEnterPin : Event()
        class OnInputPin(val pin: String): Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadingStarted -> {
                startLoading()
            }
            is Event.OnSendAgain -> {
                sendOnPhone()
            }
            is Event.OnInputPin -> {
                setPin(pin = event.pin)
            }
            is Event.OnEnterPin -> {
                sendPin()
            }
        }
    }
}