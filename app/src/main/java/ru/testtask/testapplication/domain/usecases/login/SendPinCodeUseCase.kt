package ru.testtask.testapplication.domain.usecases.login

import ru.testtask.testapplication.domain.repisotory.LoginRepository

class SendPinCodeUseCase(private val repository: LoginRepository) {
    suspend fun execute(pin: String): Unit = repository.sendCode(pinCode = pin)
}