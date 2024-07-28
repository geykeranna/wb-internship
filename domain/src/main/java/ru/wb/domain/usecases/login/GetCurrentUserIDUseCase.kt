package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface GetCurrentUserIDUseCase {
    suspend fun execute(): Flow<String>
}