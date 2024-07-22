package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository

internal class GetEventListUseCaseImpl(
    private val repository: EventRepository
) : GetEventListUseCase {
    override suspend fun execute(
        query: String?,
        userId: String?,
        state: String?,
    ): List<EventData> {
        return repository.getEvents(
            query = query,
            userId = userId,
            state = state,
        )
    }
}

interface GetEventListUseCase {
    suspend fun execute(
        query: String? = null,
        userId: String? = null,
        state: String? = null,
    ): List<EventData>
}