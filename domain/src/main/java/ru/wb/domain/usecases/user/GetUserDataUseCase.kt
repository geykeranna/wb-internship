package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData

interface GetUserDataUseCase {
    suspend fun execute(id: String?): UserData?
}