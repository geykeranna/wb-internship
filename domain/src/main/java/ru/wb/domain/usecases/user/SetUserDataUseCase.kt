package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class SetUserDataUseCaseImpl(
    private val repository: UserRepository
) : SetUserDataUseCase {
    override suspend fun execute(user: UserData): Boolean = repository.setUser(userData = user)
}

interface SetUserDataUseCase {
    suspend fun execute(user: UserData): Boolean
}