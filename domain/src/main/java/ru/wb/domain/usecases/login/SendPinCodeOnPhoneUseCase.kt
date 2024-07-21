package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class SendPinCodeOnPhoneUseCase(private val repository: LoginRepository) {
    suspend fun execute(phone: String): Unit = repository.setPhone(phoneNumber = phone)
}