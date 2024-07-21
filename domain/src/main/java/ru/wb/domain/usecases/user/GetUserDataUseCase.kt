package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

class GetUserDataUseCase(private val repository: UserRepository) {
    suspend fun execute(id: String?): UserData = repository.getUser(id = id)
}