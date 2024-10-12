package ru.wb.ui.ui.screens.auth.onevent.pin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.usecases.event.PostSubscribeOnEvent
import ru.wb.domain.usecases.login.CheckOTPCodeUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.auth.onevent.pin.components.AppointmentValidationState

internal class AppointmentPinViewModel(
    private val idEvent: String,
    private val getPhoneAuth: GetCurrentPhoneNumberUseCase,
    private val sendPinCodeOnPhoneUseCase: SendPinCodeOnPhoneUseCase,
    private val subscribeOnEvent: PostSubscribeOnEvent,
    private val checkCodeUseCase: CheckOTPCodeUseCase,
) : BaseViewModel<AppointmentPinViewModel.Event>() {
    private val _inputValue = MutableStateFlow("")
    private val inputValue: StateFlow<String> = _inputValue

    private val _phone = MutableStateFlow("")
    private val phone: StateFlow<String> = _phone

    private val _userId = MutableStateFlow("")
    private val userId: StateFlow<String> = _userId

    private val _pinVerificationStatus = MutableStateFlow<Boolean?>(null)
    private val pinVerificationStatus: StateFlow<Boolean?> = _pinVerificationStatus

    private val _state = MutableStateFlow(BaseState.SUCCESS)
    private val state: StateFlow<BaseState> = _state

    private val _context = MutableStateFlow(AppointmentValidationState.defaultValue)
    private val context: StateFlow<AppointmentValidationState> = _context

    private val _textButtonState = MutableStateFlow<List<Any?>>(listOf(null, false))
    private val textButtonState: StateFlow<List<Any?>> = _textButtonState

    init {
        obtainEvent(Event.OnStartLoading)
        configureButtonState()
    }

    fun getInputDataFlow(): StateFlow<String> = inputValue

    fun getUserIdFlow(): StateFlow<String> = userId

    fun getTextButtonFlow(): StateFlow<List<Any?>> = textButtonState

    fun getValidateStatus(): StateFlow<Boolean?> = pinVerificationStatus

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getContextFlow(): StateFlow<AppointmentValidationState> = context

    private fun fetchData() = viewModelScope.launch {
        getPhoneAuth.execute().collect { options ->
            when(options) {
                is LoadState.Success -> {
                    _phone.emit(options.data)
                    _context.emit(AppointmentValidationState(
                        contextString = "Отправили код на ${phone.value}",
                        isActive = false
                    ))
                }
                else -> {}
            }
        }
    }

    private fun onChangeValue(newValue: String) = viewModelScope.launch {
        _inputValue.emit(newValue)
        _context.emit(AppointmentValidationState(
            contextString = "Отправили код на ${phone.value}",
            isActive = inputValue.value.length == 4
        ))
        if (pinVerificationStatus.value == false){
            _pinVerificationStatus.emit(null)
        }
    }

    private fun submitForm() = viewModelScope.launch {
        subscribeOnEvent.execute(
            idUser = "local",
            idEvent = idEvent,
        )
    }

    private fun sendPin() = viewModelScope.launch {
        sendPinCodeOnPhoneUseCase.execute(phone.value)
    }

    private fun configureButtonState() = viewModelScope.launch {
        var counter = 10
        while (true) {
            _textButtonState.emit(listOf(
                "Получить новый код через $counter",
                false
            ))
            delay(1000)
            if (counter == 0) break
            counter--
        }
        _textButtonState.emit(listOf("Получить новый код", true))
    }

    private fun checkStatus() = viewModelScope.launch {
        checkCodeUseCase.execute(pin = inputValue.value).collect { result ->
            when (result) {
                is LoadState.Success -> {
                    _pinVerificationStatus.emit(result.data.isNotBlank())
                    if (result.data.isNotBlank()) {
                        submitForm()
                        _userId.emit(result.data)
                    } else {
                        _context.emit(AppointmentValidationState(
                            contextString = "Неправильный код",
                            isActive = false,
                        ))
                        configureButtonState()
                    }
                }
                is LoadState.Error -> {
                    _pinVerificationStatus.emit(null)
                    _context.emit(AppointmentValidationState(
                        contextString = "Не получилось проверить код! Попробуйте еще раз.",
                        isActive = false,
                    ))
                }
                else -> {}
            }
        }
    }

    private fun onSendNewCode() = viewModelScope.launch{
        sendPin()
        _inputValue.emit("")
        _pinVerificationStatus.emit(null)
        _context.emit(AppointmentValidationState(
            contextString = "Отправили код на ${phone.value}",
            isActive = false,
        ))
        configureButtonState()
    }

    sealed class Event : BaseEvent() {
        data object OnStartLoading : Event()
        data object OnEnterClick : Event()
        data object OnSendNewCode: Event()
        class OnChangeValue(val inputValue: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnStartLoading -> {
                fetchData()
            }
            is Event.OnEnterClick -> {
                checkStatus()
            }
            is Event.OnSendNewCode -> {
                onSendNewCode()
            }
            is Event.OnChangeValue -> {
                onChangeValue(newValue = event.inputValue)
            }
        }
    }
}