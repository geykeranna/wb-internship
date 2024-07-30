package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface GetCurrentPhoneNumberUseCase {
    fun execute(): Flow<String>
}