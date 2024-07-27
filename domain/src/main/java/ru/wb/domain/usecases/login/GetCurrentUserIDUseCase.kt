package ru.wb.domain.usecases.login

interface GetCurrentUserIDUseCase {
    suspend fun execute(): String
}