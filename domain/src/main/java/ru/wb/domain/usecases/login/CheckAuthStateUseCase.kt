package ru.wb.domain.usecases.login

import kotlinx.coroutines.flow.Flow

interface CheckAuthStateUseCase {
    fun execute(): Flow<Boolean>
}