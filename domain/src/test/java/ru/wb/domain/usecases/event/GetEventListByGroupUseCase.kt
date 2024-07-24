package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository

internal class GetEventListByGroupUseCaseImpl(
    private val repository: EventRepository
) : GetEventListByGroupUseCase {
    override suspend fun execute(
        query: String?,
        userId: String?
    ) : List<EventsByGroup> {
        return repository.getEventsByGroup(
            query = query,
            userId = userId
        )
    }
}

interface GetEventListByGroupUseCase {
    suspend fun execute(query: String? = null, userId: String? = null): List<EventsByGroup>
}