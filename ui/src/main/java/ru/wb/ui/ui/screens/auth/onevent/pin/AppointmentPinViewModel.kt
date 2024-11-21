package ru.wb.ui.ui.screens.auth.onevent.pin

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.usecases.login.CheckOTPCodeUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionCommunityStatusUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionEventStatusUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentScreenTitle
import ru.wb.ui.ui.screens.auth.onevent.pin.components.AppointmentValidationState

internal class AppointmentPinViewModel(
    private val getUserData: GetUserDataUseCase,
    private val sendPinCodeOnPhoneUseCase: SendPinCodeOnPhoneUseCase,
    private val subscribeOnEvent: ChangeSubscriptionEventStatusUseCase,
    private val subscribeOnCommunity: ChangeSubscriptionCommunityStatusUseCase,
    private val checkCodeUseCase: CheckOTPCodeUseCase,
) : BaseViewModel<AppointmentPinViewModel.Event>() {
    private val _inputValue = MutableStateFlow("")
    private val inputValue: StateFlow<String> = _inputValue

    private val _phone = MutableStateFlow("")
    private val phone: StateFlow<String> = _phone

    private val _pinVerificationStatus = MutableStateFlow<Boolean?>(null)
    private val pinVerificationStatus: StateFlow<Boolean?> = _pinVerificationStatus

    private val _state = MutableStateFlow(BaseState.SUCCESS)
    private val state: StateFlow<BaseState> = _state

    private val _userStatus = MutableStateFlow(false)
    private val userStatus: StateFlow<Boolean> = _userStatus

    private val _context = MutableStateFlow(AppointmentValidationState.defaultValue)
    private val context: StateFlow<AppointmentValidationState> = _context

    private val _textButtonState = MutableStateFlow<List<Any?>>(listOf(null, false))
    private val textButtonState: StateFlow<List<Any?>> = _textButtonState

    init {
        obtainEvent(Event.OnStartLoading)
        configureButtonState()
    }

    fun getInputDataFlow(): StateFlow<String> = inputValue

    fun getTextButtonFlow(): StateFlow<List<Any?>> = textButtonState

    fun getValidateStatus(): StateFlow<Boolean?> = pinVerificationStatus

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getContextFlow(): StateFlow<AppointmentValidationState> = context

    fun getUserStatusFlow(): StateFlow<Boolean> = userStatus

    sealed class Event : BaseEvent() {
        data object OnStartLoading : Event()
        data object OnSendNewCode: Event()
        class OnChangeValue(val inputValue: String) : Event()
        class OnEnterClick(val group: String, val id: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnStartLoading -> {
                fetchData()
            }
            is Event.OnEnterClick -> {
                checkStatus(group = event.group, id = event.id)
            }
            is Event.OnSendNewCode -> {
                onSendNewCode()
            }
            is Event.OnChangeValue -> {
                onChangeValue(newValue = event.inputValue)
            }
        }
    }

    private fun fetchData() = viewModelScope.launch {
        getUserData.getPhone().collect { options ->
            when(options) {
                is LoadState.Success -> {
                    _phone.emit(options.data)
                    _context.emit(AppointmentValidationState(
                        contextString = "Отправили код на ${options.data}",
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

    private fun submitForm(group: String, id: String) = viewModelScope.launch {
        getUserData.getName().collect { loadState ->
            when(loadState) {
                is LoadState.Success -> _userStatus.emit(loadState.data.isNotBlank())
                else -> _userStatus.emit(false)
            }
        }
        when(group){
            AppointmentScreenTitle.EVENT.title -> subscribeOnEvent.execute(eventId = id)
            AppointmentScreenTitle.COMMUNITY.title -> subscribeOnCommunity.execute(communityId = id)
        }
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

    private fun checkStatus(group: String, id: String) = viewModelScope.launch {
        checkCodeUseCase.execute(pin = inputValue.value).collect { result ->
            when (result) {
                is LoadState.Success -> {
                    _pinVerificationStatus.emit(result.data)
                    if (result.data) {
                        submitForm(group = group, id = id)
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
                        isActive = true,
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
}