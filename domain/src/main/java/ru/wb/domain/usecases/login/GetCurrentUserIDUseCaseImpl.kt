package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

internal class GetCurrentUserIDUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentUserIDUseCase {
    override suspend fun execute(): String = repository.getUserID()
}