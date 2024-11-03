package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository

internal class DeleteUserListUseCaseImpl(
    private val repository: UserRepository
) : DeleteUserListUseCase {
    override fun execute(): Flow<LoadState<Boolean>> {
        return repository.deleteUser()
    }
}