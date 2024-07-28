package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repisotory.LoginRepository

internal class SendPinCodeOnPhoneUseCaseImpl(
    private val repository: LoginRepository
) : SendPinCodeOnPhoneUseCase {
    override suspend fun execute(
        phone: String
    ): Flow<Boolean> = repository.sendOnPhone(phoneNumber = phone)
}