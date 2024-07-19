package ru.testtask.testapplication.domain.usecases.user

import ru.testtask.testapplication.repository.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.UserRepository

class SetUserDataUseCase(private val repository: UserRepository) {
    suspend fun execute(user: UserData): Boolean = repository.setUser(userData = user)
}