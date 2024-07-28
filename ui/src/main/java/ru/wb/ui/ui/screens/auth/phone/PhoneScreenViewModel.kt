package ru.wb.ui.ui.screens.auth.phone

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.ui.ui.base.BaseEvent
import ru.wb.ui.ui.base.BaseViewModel
import ru.wb.ui.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER

internal class PhoneScreenViewModel(
    private val sendPin: SendPinCodeOnPhoneUseCase,
) : BaseViewModel<PhoneScreenViewModel.Event>() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber

    private val _selectedPhoneCode = MutableStateFlow(CountryCodes.shimmerData.first())
    private val selectedPhoneCode: StateFlow<CountryCodes> = _selectedPhoneCode

    private val _phoneCountryCodeList = MutableStateFlow(CountryCodes.shimmerData)
    private val phoneCountryCodeList: StateFlow<List<CountryCodes>> = _phoneCountryCodeList

    fun getPhoneNumberFlow(): StateFlow<String> = phoneNumber

    fun getPhoneCountryCodeListFlow(): StateFlow<List<CountryCodes>> = phoneCountryCodeList

    fun getSelectedPhoneCodeFlow(): StateFlow<CountryCodes> = selectedPhoneCode

    fun getValidateState(): Boolean {
        val countNumInMask = selectedPhoneCode.value.mask.count {
            num -> num == CHAR_IN_MASK_FOR_NUMBER
        }
        return phoneNumber.value.length == countNumInMask
    }

    private fun setSelectedPhoneCode(selected: CountryCodes) = viewModelScope.launch {
        _selectedPhoneCode.emit(selected)
    }

    private fun sendPin() = viewModelScope.launch {
        sendPin.execute(phone = "${selectedPhoneCode.value.countryCode}${phoneNumber.value}")
        _phoneNumber.emit("")
    }

    private fun setPhoneNumber(phone: String) = viewModelScope.launch {
        _phoneNumber.emit(phone)
    }

    sealed class Event : BaseEvent() {
        data object OnSend : Event()
        class OnEnterNumber(val phone: String): Event()
        class OnSelectCode(val selected: CountryCodes): Event()
    }

    override fun obtainEvent(event: Event) {
        when (event) {
            is Event.OnSend -> {
                sendPin()
            }
            is Event.OnEnterNumber -> {
                setPhoneNumber(phone = event.phone)
            }
            is Event.OnSelectCode -> {
                setSelectedPhoneCode(event.selected)
            }
        }
    }
}