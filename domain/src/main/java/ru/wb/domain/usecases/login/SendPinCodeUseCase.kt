package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class SendPinCodeUseCase(private val repository: LoginRepository) {
    suspend fun execute(pin: String): Unit = repository.sendCode(pinCode = pin)
}