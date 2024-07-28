package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData

interface PostUserDataUseCase {
    suspend fun execute(user: UserData): Flow<Boolean>
}