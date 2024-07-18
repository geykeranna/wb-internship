package ru.testtask.testapplication.domain.usecases.login

import ru.testtask.testapplication.domain.repisotory.LoginRepository

class GetCurrentPhoneNumberUseCase(private val repository: LoginRepository) {
    suspend fun execute(): String = repository.getPhoneAuth()
}