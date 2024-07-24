package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class CheckAuthStateUseCaseImpl(
    private val repository: LoginRepository
) : CheckAuthStateUseCase {
    override suspend fun execute(): Boolean = repository.getAuthState()
}

interface CheckAuthStateUseCase {
    suspend fun execute(): Boolean
}