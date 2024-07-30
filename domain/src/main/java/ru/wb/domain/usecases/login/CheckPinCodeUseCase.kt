package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface CheckPinCodeUseCase {
    fun execute(pin: String): Flow<Boolean>
}