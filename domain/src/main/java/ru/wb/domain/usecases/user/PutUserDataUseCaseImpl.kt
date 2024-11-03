package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository

internal class PutUserDataUseCaseImpl(
    private val repository: UserRepository
) : PutUserDataUseCase {
    override fun execute(user: UserData): Flow<LoadState<UserData?>> {
        return repository.putUser(userData = user)
    }
}