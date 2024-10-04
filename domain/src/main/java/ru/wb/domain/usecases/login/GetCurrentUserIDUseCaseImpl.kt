package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.LoginRepository

internal class GetCurrentUserIDUseCaseImpl(
    private val repository: LoginRepository
) : GetCurrentUserIDUseCase {
    override fun execute(): Flow<LoadState<String>> = repository.getUserID()
}