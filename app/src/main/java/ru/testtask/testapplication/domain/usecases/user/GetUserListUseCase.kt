package ru.testtask.testapplication.domain.usecases.user

import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.UserRepository

class GetUserListUseCase(private val repository: UserRepository) {
    suspend fun execute(): List<UserData> = repository.getUsers()
}