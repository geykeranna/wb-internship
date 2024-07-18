package ru.testtask.testapplication.ui.screens.auth.phone

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.testtask.testapplication.domain.usecases.login.SendPinCodeOnPhoneUseCase

class PhoneScreenViewModel(
    private val sendPin: SendPinCodeOnPhoneUseCase,
) : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber

    fun getPhoneNumber(): StateFlow<String> = phoneNumber


}