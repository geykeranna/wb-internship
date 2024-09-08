package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface CheckOTPCodeUseCase {
    fun execute(pin: String): Flow<Boolean>
}