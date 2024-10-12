package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface CheckOTPCodeUseCase {
    fun execute(pin: String): Flow<LoadState<String>>
}