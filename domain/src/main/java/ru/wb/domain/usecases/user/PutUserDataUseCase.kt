package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class PutUserDataUseCaseImpl(
    private val repository: UserRepository
) : PutUserDataUseCase {
    override suspend fun execute(user: UserData): Boolean = repository.putUser(userData = user)
}

interface PutUserDataUseCase {
    suspend fun execute(user: UserData): Boolean
}