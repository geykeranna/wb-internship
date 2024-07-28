package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repisotory.LoginRepository

internal class GetCurrentPhoneNumberUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentPhoneNumberUseCase {
    override suspend fun execute(): Flow<String> = repository.getPhoneAuth()
}