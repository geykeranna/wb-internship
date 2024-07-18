package ru.testtask.testapplication.domain.usecases.login

import ru.testtask.testapplication.domain.repisotory.LoginRepository

class SendPinCodeOnPhoneUseCase(private val repository: LoginRepository) {
    suspend fun execute(phone: String): Unit = repository.sendCode(phoneNumber = phone)
}