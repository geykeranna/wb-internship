package ru.wb.domain.usecases.login

interface GetCurrentPhoneNumberUseCase {
    suspend fun execute(): String
}