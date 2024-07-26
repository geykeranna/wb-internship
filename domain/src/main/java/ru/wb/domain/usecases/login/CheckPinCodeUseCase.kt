package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

internal class CheckPinCodeUseCaseImpl(
    private val repository: LoginRepository
) : CheckPinCodeUseCase {
    override suspend fun execute(pin: String): Boolean = repository.checkCode(pinCode = pin)
}

interface CheckPinCodeUseCase {
    suspend fun execute(pin: String): Boolean
}