package ru.testtask.testapplication.domain.usecases.login

import ru.testtask.testapplication.domain.repisotory.LoginRepository

class GetCurrentUserIDUseCase(private val repository: LoginRepository) {
    suspend fun execute(): String = repository.getUserID()
}