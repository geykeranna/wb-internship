package ru.wb.domain.usecases.user

interface HandleGoingEventUseCase {
    suspend fun execute(eventId: String): Boolean
}