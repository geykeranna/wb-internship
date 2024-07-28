package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repisotory.LoginRepository

internal class GetCurrentUserIDUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentUserIDUseCase {
    override suspend fun execute(): Flow<String> = repository.getUserID()
}