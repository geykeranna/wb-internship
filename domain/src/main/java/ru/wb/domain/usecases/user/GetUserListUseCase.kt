package ru.wb.domain.usecases.user

import ru.wb.domain.model.UserData

interface GetUserListUseCase {
    suspend fun execute(): List<UserData>
}