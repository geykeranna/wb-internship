package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.LoginRepository

class CheckAuthStateUseCaseImpl(
    private val repository: LoginRepository
) : CheckAuthStateUseCase {
    override fun execute(): Flow<LoadState<Boolean>> = repository.getAuthState()
}