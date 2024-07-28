package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData

interface GetUserDataUseCase {
    suspend fun execute(id: String? = null): Flow<UserData?>
}