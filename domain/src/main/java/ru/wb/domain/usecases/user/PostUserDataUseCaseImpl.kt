package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.UserRepository

internal class PostUserDataUseCaseImpl(
    private val repository: UserRepository
) : PostUserDataUseCase {
    override   fun execute(user: UserData): Flow<Boolean> {
        return repository.postUser(userData = user)
    }
}