package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class GetUserListUseCaseImpl(
    private val repository: UserRepository
) : GetUserListUseCase {
    override suspend fun execute(): List<UserData> = repository.getUsers()
}

interface GetUserListUseCase {
    suspend fun execute(): List<UserData>
}