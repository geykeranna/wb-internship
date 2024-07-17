package ru.testtask.testapplication.domain.usecases.user

import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.UserRepository

class GetUserDataUseCase(private val repository: UserRepository) {
    suspend fun execute(id: String): UserData = repository.getUser(id = id)
}