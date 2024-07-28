package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface SendPinCodeOnPhoneUseCase {
    suspend fun execute(phone: String): Flow<Boolean>
}