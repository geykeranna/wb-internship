package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repisotory.UserRepository

internal class HandleGoingEventImpl(
    private val repository: UserRepository
) : HandleGoingEventUseCase {
    override suspend fun execute(eventId: String): Flow<Boolean> {
        return repository.handleGoingEvent(eventID = eventId)
    }
}