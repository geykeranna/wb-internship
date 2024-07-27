package ru.wb.domain.usecases.login

interface CheckAuthStateUseCase {
    suspend fun execute(): Boolean
}