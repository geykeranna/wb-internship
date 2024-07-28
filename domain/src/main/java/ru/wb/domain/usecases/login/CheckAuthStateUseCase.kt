package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface CheckAuthStateUseCase {
    suspend fun execute(): Flow<Boolean>
}