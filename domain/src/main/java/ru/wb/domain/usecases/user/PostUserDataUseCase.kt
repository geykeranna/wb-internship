package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class PostUserDataUseCaseImpl(
    private val repository: UserRepository
) : PostUserDataUseCase {
    override suspend fun execute(user: UserData): Boolean = repository.postUser(userData = user)
}

interface PostUserDataUseCase {
    suspend fun execute(user: UserData): Boolean
}