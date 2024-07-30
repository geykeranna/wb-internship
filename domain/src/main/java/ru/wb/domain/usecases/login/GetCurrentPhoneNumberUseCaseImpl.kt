package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.LoginRepository

internal class GetCurrentPhoneNumberUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentPhoneNumberUseCase {
    override fun execute(): Flow<String> = repository.getPhoneAuth()
}