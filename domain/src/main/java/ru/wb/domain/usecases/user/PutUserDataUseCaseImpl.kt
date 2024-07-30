package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.UserRepository

internal class PutUserDataUseCaseImpl(
    private val repository: UserRepository
) : PutUserDataUseCase {
    override   fun execute(user: UserData): Flow<Boolean> {
        return repository.putUser(userData = user)
    }
}