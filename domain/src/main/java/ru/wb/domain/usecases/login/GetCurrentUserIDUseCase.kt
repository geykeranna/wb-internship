package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface GetCurrentUserIDUseCase {
    fun execute(): Flow<String>
}