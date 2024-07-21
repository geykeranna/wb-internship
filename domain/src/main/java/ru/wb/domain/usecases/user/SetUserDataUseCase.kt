package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class SetUserDataUseCase(private val repository: UserRepository) {
    suspend fun execute(user: UserData): Boolean = repository.setUser(userData = user)
}