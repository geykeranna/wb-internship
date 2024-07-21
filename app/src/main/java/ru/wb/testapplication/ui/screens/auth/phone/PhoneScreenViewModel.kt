package ru.wb.testapplication.ui.screens.auth.phone

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.testapplication.ui.base.BaseEvent
import ru.wb.testapplication.ui.base.BaseViewModel
import ru.wb.testapplication.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER

class PhoneScreenViewModel(
    private val sendPin: SendPinCodeOnPhoneUseCase,
) : BaseViewModel<PhoneScreenViewModel.Event>() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber

    private val _selectedPhoneCode = MutableStateFlow(CountryCodes.shimmerData.first())
    private val selectedPhoneCode: StateFlow<CountryCodes> = _selectedPhoneCode

    private val _phoneCountryCodeList = MutableStateFlow(CountryCodes.shimmerData)
    private val phoneCountryCodeList: StateFlow<List<CountryCodes>> = _phoneCountryCodeList

    fun getPhoneNumber(): StateFlow<String> = phoneNumber

    fun getPhoneCountryCodeList(): StateFlow<List<CountryCodes>> = phoneCountryCodeList

    fun getSelectedPhoneCode(): StateFlow<CountryCodes> = selectedPhoneCode

    fun getValidateState(): Boolean {
        val countNumInMask = selectedPhoneCode.value.mask.count {
            num -> num == CHAR_IN_MASK_FOR_NUMBER
        }
        return phoneNumber.value.length == countNumInMask
    }

    fun onChangePhoneNumber(phone: String) {
        obtainEvent(Event.OnEnterNumber(phone = phone))
    }

    fun setSelectCode(value: CountryCodes){
        obtainEvent(Event.OnSelectCode(selected = value))
    }

    private fun setSelectedPhoneCode(selected: CountryCodes) {
        _selectedPhoneCode.value = selected
    }

    private fun sendPin() = viewModelScope.launch {
        sendPin.execute(phone = "${selectedPhoneCode.value.countryCode}${phoneNumber.value}")
        _phoneNumber.value = ""
    }

    private fun setPhoneNumber(phone: String) {
        _phoneNumber.value = phone
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