package ru.wb.ui.ui.screens.auth.onevent.phone

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.usecases.common.GetCountryCodesListUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER

internal class AppointmentPhoneViewModel(
    private val sendPinCodeOnPhoneUseCase: SendPinCodeOnPhoneUseCase,
    private val setUserData: PostUserDataUseCase,
    private val getCountryCodesListUseCase: GetCountryCodesListUseCase,
) : BaseViewModel<AppointmentPhoneViewModel.Event>() {
    private val _inputValue = MutableStateFlow("")
    private val inputValue: StateFlow<String> = _inputValue

    private val _countryCodesOptions = MutableStateFlow(CountryCodes.defaultData)
    private val countryCodesOptions: StateFlow<List<CountryCodes>> = _countryCodesOptions

    private val _selectedCountryPhone = MutableStateFlow(CountryCodes.defaultData.first())
    private val selectedCountryPhone: StateFlow<CountryCodes> = _selectedCountryPhone

    private val _validationStatus = MutableStateFlow(false)
    private val validationStatus: StateFlow<Boolean> = _validationStatus

    init {
        obtainEvent(Event.OnStartLoading)
    }

    fun getInput(): StateFlow<String> = inputValue

    fun getSelectedCountryPhoneFlow(): StateFlow<CountryCodes> = selectedCountryPhone

    fun getCountryCodesOptionsFlow(): StateFlow<List<CountryCodes>> = countryCodesOptions

    fun getValidationFlow(): StateFlow<Boolean> = validationStatus

    sealed class Event : BaseEvent() {
        data object OnStartLoading : Event()
        data object OnEnterClick : Event()
        class OnSelectedPhoneCountryCode(val countryCodes: CountryCodes) : Event()
        class OnChangeValue(val inputValue: String) : Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnStartLoading -> {
                fetchData()
            }
            is Event.OnEnterClick -> {
                sendPin()
                setUserPhone()
            }
            is Event.OnSelectedPhoneCountryCode -> {
                changeSelectedCountryCode(newCountryCodes = event.countryCodes)
            }
            is Event.OnChangeValue -> {
                onChangeValue(newValue = event.inputValue)
            }
        }
    }

    private fun fetchData() = viewModelScope.launch {
        getCountryCodesListUseCase.execute().collect { options ->
            when(options) {
                is LoadState.Success -> {
                    _countryCodesOptions.emit(options.data)
                }
                else -> {}
            }
        }
    }

    private fun checkPhoneValue() = viewModelScope.launch {
        val countNumInMask = selectedCountryPhone.value.mask.count { num ->
            num == CHAR_IN_MASK_FOR_NUMBER
        }
        _validationStatus.emit(inputValue.value.length == countNumInMask)
    }

    private fun onChangeValue(newValue: String) = viewModelScope.launch {
        _inputValue.emit(newValue)
        checkPhoneValue()
    }

    private fun changeSelectedCountryCode(newCountryCodes: CountryCodes) = viewModelScope.launch {
        _selectedCountryPhone.emit(newCountryCodes)
    }

    private fun setUserPhone() = viewModelScope.launch {
        setUserData.setPhone(inputValue.value)
    }

    private fun sendPin() = viewModelScope.launch {
        sendPinCodeOnPhoneUseCase.execute(inputValue.value)
    }
}