package ru.wb.domain.usecases.login

interface CheckPinCodeUseCase {
    suspend fun execute(pin: String): Boolean
}