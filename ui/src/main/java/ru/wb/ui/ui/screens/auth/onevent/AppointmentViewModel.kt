package ru.wb.ui.ui.screens.auth.onevent

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.UserData
import ru.wb.domain.usecases.common.GetCountryCodesListUseCase
import ru.wb.domain.usecases.event.PostSubscribeOnEvent
import ru.wb.domain.usecases.login.CheckOTPCodeUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseState
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentFormData
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentScreenState

internal class AppointmentViewModel(
    private val idEvent: String,
    private val subscribeOnEvent: PostSubscribeOnEvent,
    private val setUserData: PostUserDataUseCase,
    private val checkCodeUseCase: CheckOTPCodeUseCase,
    private val getCountryCodesListUseCase: GetCountryCodesListUseCase,
) : BaseViewModel<AppointmentViewModel.Event>() {
    private val _formData = MutableStateFlow(AppointmentFormData.defaultData)
    private val formData: StateFlow<AppointmentFormData> = _formData

    private val _isSuccessfulRegistration = MutableStateFlow(false)
    private val isSuccessfulRegistration: StateFlow<Boolean> = _isSuccessfulRegistration

    private val _countryCodesOptions = MutableStateFlow(CountryCodes.defaultData)
    private val countryCodesOptions: StateFlow<List<CountryCodes>> = _countryCodesOptions

    private val _selectedCountryPhone = MutableStateFlow(CountryCodes.defaultData.first())
    private val selectedCountryPhone: StateFlow<CountryCodes> = _selectedCountryPhone

    private val _pinVerificationStatus = MutableStateFlow<Boolean?>(null)
    private val pinVerificationStatus: StateFlow<Boolean?> = _pinVerificationStatus

    private val _screenState = MutableStateFlow(AppointmentScreenState.ENTER_NAME)
    private val screenState: StateFlow<AppointmentScreenState> = _screenState

    private val _state = MutableStateFlow(BaseState.SUCCESS)
    private val state: StateFlow<BaseState> = _state

    private val _textButtonState = MutableStateFlow<List<Any?>>(listOf(null, false))
    private val textButtonState: StateFlow<List<Any?>> = _textButtonState

    init {
        obtainEvent(Event.OnLoadStarted)
    }

    fun getFormDataFlow(): StateFlow<AppointmentFormData> = formData

    fun getTextButtonFlow(): StateFlow<List<Any?>> = textButtonState

    fun getSuccessfulRegistrationStatusFlow(): StateFlow<Boolean> = isSuccessfulRegistration

    fun getValidateStatus(): StateFlow<Boolean?> = pinVerificationStatus

    fun getSelectedCountryPhoneFlow(): StateFlow<CountryCodes> = selectedCountryPhone

    fun getCountryCodesOptionsFlow(): StateFlow<List<CountryCodes>> = countryCodesOptions

    fun getScreenStateFlow(): StateFlow<AppointmentScreenState> = screenState

    fun getStateFlow(): StateFlow<BaseState> = state

    fun getButtonStatusEnable(): Boolean = when {
        screenState.value == AppointmentScreenState.ENTER_NAME && formData.value.name.isNotEmpty()
            || screenState.value == AppointmentScreenState.ENTER_PHONE && checkPhoneValue()
            || screenState.value == AppointmentScreenState.ENTER_PIN && formData.value.pin.length == 4 ->
                true
        else -> false
    }

    fun getContextString(): String = when(screenState.value) {
        AppointmentScreenState.ENTER_PIN -> {
            if(pinVerificationStatus.value == false) {
                "Неправильный код"
            } else {
                "Отправили код на" +
                        " ${selectedCountryPhone.value.countryCode} ${formData.value.phone}"
            }
        }
        else -> ""
    }

    private fun checkPhoneValue(): Boolean {
        val countNumInMask = selectedCountryPhone.value.mask.count {
                num -> num == CHAR_IN_MASK_FOR_NUMBER
        }
        return formData.value.phone.length == countNumInMask
    }

    private fun startLoading() = viewModelScope.launch {
        _state.emit(BaseState.LOADING)
        getCountryCodesListUseCase.execute().collect { options ->
            _countryCodesOptions.emit(options)
            _state.emit(BaseState.SUCCESS)
        }
    }

    private fun changeScreenStatus() = viewModelScope.launch {
        when {
            screenState.value == AppointmentScreenState.ENTER_NAME
                    && formData.value.name.isNotEmpty() -> {
                _screenState.emit(AppointmentScreenState.ENTER_PHONE)
            }
            screenState.value == AppointmentScreenState.ENTER_PHONE
                    && formData.value.phone.isNotEmpty() -> {
                _screenState.emit(AppointmentScreenState.ENTER_PIN)
            }
            screenState.value == AppointmentScreenState.ENTER_PIN
                    && formData.value.pin.length == 4 -> {
                checkStatus(formData.value.pin)
            }
        }
    }

    private fun onChangeValue(newValue: String) = viewModelScope.launch {
        when(screenState.value) {
            AppointmentScreenState.ENTER_NAME -> {
                _formData.emit(formData.value.copy(name = newValue))
            }
            AppointmentScreenState.ENTER_PHONE -> {
                _formData.emit(formData.value.copy(phone = newValue))
            }
            AppointmentScreenState.ENTER_PIN -> {
                _formData.emit(formData.value.copy(pin = newValue))
            }
        }
    }

    private fun changeSelectedCountryCode(newCountryCodes: CountryCodes) = viewModelScope.launch {
        _selectedCountryPhone.emit(newCountryCodes)
    }

    private fun checkStatus(pin: String) = viewModelScope.launch {
        checkCodeUseCase.execute(pin = pin).collect { result ->
            _pinVerificationStatus.emit(result)
        }
        when{
            _pinVerificationStatus.value == true -> submitForm()
            else -> configureButtonState()
        }
    }

    private fun submitForm() = viewModelScope.launch {
        var userData: UserData? = null
        setUserData.execute(UserData(
            id = "",
            name = formData.value.name,
            phone = formData.value.phone,
        )).collect { response ->
            userData = response
        }
        userData?.let {
            subscribeOnEvent.execute(
                idUser = it.id,
                idEvent = idEvent
            ).collect {
                _isSuccessfulRegistration.emit(true)
            }
        }
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
        _textButtonState.emit(listOf(
            "Получить новый код",
            true
        ))
    }

    sealed class Event : BaseEvent() {
        data object OnLoadStarted : Event()
        data object OnEnterClick : Event()
        class OnSelectedPhoneCountryCode(val countryCodes: CountryCodes) : Event()
        class OnChangeValue(val inputValue: String) : Event()
        class CheckPinStatus(val pin: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnLoadStarted -> {
                startLoading()
            }
            is Event.OnEnterClick -> {
                changeScreenStatus()
            }
            is Event.CheckPinStatus -> {
                checkStatus(pin = event.pin)
            }
            is Event.OnSelectedPhoneCountryCode -> {
                changeSelectedCountryCode(newCountryCodes = event.countryCodes)
            }
            is Event.OnChangeValue -> {
                onChangeValue(newValue = event.inputValue)
            }
        }
    }
}