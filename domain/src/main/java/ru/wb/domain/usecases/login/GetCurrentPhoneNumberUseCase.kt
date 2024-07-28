package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface GetCurrentPhoneNumberUseCase {
    suspend fun execute(): Flow<String>
}