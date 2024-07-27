package ru.wb.domain.usecases.login

interface SendPinCodeOnPhoneUseCase {
    suspend fun execute(phone: String): Boolean
}