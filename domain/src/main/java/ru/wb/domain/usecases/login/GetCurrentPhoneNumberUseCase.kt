package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class GetCurrentPhoneNumberUseCase(private val repository: LoginRepository) {
    suspend fun execute(): String = repository.getPhoneAuth()
}