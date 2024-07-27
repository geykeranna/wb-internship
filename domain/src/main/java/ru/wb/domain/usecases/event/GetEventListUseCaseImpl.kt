package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

internal class GetEventListUseCaseImpl(
    private val repository: EventRepository
) : GetEventListUseCase {
    override suspend fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        userId: String?,
        state: String?,
    ): List<EventData> {
        return repository.getEvents(
            EventGetRequest(
                limit = limit,
                offset = offset,
                query = query,
                userId = userId,
                state = state,
            )
        )
    }
}