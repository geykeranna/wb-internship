package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class GetCurrentUserIDUseCase(private val repository: LoginRepository) {
    suspend fun execute(): String = repository.getUserID()
}