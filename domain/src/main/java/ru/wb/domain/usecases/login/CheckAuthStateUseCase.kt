package ru.wb.domain.usecases.login

import ru.wb.domain.repisotory.LoginRepository

class CheckAuthStateUseCase(private val repository: LoginRepository) {
    suspend fun execute(): Boolean = repository.getAuthState()
}