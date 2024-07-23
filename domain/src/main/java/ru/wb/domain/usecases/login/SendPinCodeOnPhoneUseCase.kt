package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

internal class SendPinCodeOnPhoneUseCaseImpl(
    private val repository: LoginRepository
) : SendPinCodeOnPhoneUseCase {
    override suspend fun execute(phone: String): Unit = repository.setPhone(phoneNumber = phone)
}

interface SendPinCodeOnPhoneUseCase {
    suspend fun execute(phone: String)
}