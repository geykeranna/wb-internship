package ru.wb.ui.ui.screens.auth.pin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import ru.wb.domain.usecases.login.CheckPinCodeUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.Constants.PASS_LENGTH_IN_PASS_FIELD

internal class PinCodeScreenViewModel(
    private val getPhone: GetCurrentPhoneNumberUseCase,
    private val sendPhone: SendPinCodeOnPhoneUseCase,
    private val sendPin: CheckPinCodeUseCase,
) : BaseViewModel<PinCodeScreenViewModel.Event>() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber

    private val _pin = MutableStateFlow("")
    private val pin: StateFlow<String> = _pin

    fun getPhoneNumberFlow(): StateFlow<String> = phoneNumber

    fun getPinValueFlow(): StateFlow<String> = pin

    fun getValidateState(): Boolean {
        return pin.value.length == PASS_LENGTH_IN_PASS_FIELD
    }

    private fun startLoading() = viewModelScope.launch {
        getPhone.execute().collect{
            _phoneNumber.emit(it)
        }

    }

    private fun sendPin() = viewModelScope.launch {
        sendPin.execute(pin = pin.value)
        _pin.emit("")
    }

    private fun sendOnPhone() = viewModelScope.launch {
        sendPhone.execute(phone = phoneNumber.value)
        _pin.emit("")
    }

    private fun setPin(pin: String) = viewModelScope.launch {
        _pin.emit(pin)
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