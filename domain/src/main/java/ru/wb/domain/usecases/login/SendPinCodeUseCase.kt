package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

internal class SendPinCodeUseCaseImpl(
    private val repository: LoginRepository
) : SendPinCodeUseCase {
    override suspend fun execute(pin: String): Unit = repository.sendCode(pinCode = pin)
}

interface SendPinCodeUseCase {
    suspend fun execute(pin: String)
}