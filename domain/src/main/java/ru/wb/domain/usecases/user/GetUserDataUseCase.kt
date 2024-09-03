package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData

interface GetUserDataUseCase {
    fun execute(id: String?): Flow<UserData>
}