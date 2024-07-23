package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class GetUserDataUseCaseImpl(
    private val repository: UserRepository
) : GetUserDataUseCase {
    override suspend fun execute(id: String?): UserData = repository.getUser(id = id)
}

interface GetUserDataUseCase {
    suspend fun execute(id: String?): UserData
}