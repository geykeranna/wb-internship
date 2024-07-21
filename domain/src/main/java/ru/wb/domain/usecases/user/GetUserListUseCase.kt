package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class GetUserListUseCase(private val repository: UserRepository) {
    suspend fun execute(): List<UserData> = repository.getUsers()
}