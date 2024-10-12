package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState

interface GetUserDataUseCase {
    fun execute(id: String?): Flow<LoadState<UserData>>

    fun getName(): Flow<LoadState<String>>

    fun getPhone(): Flow<LoadState<String>>
}