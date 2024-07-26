package ru.wb.domain.usecases.user

import ru.wb.domain.repisotory.UserRepository

internal class HandleGoingEventImpl(
    private val repository: UserRepository
) : HandleGoingEventUseCase {
    override suspend fun execute(eventId: String): Boolean {
        return repository.handleGoingEvent(eventID = eventId)
    }
}

interface HandleGoingEventUseCase {
    suspend fun execute(eventId: String): Boolean
}