package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

internal class GetCurrentPhoneNumberUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentPhoneNumberUseCase {
    override suspend fun execute(): String = repository.getPhoneAuth()
}

interface GetCurrentPhoneNumberUseCase {
    suspend fun execute(): String
}