package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repisotory.LoginRepository

class CheckAuthStateUseCaseImpl(
    private val repository: LoginRepository
) : CheckAuthStateUseCase {
    override suspend fun execute(): Flow<Boolean> = repository.getAuthState()
}