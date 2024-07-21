package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository

class GetEventListUseCase(private val repository: EventRepository) {
    suspend fun execute(
        query: String? = null,
        userId: String? = null,
        state: String? = null,
    ): List<EventData> {
        return repository.getEvents(
            query = query,
            userId = userId,
            state = state,
        )
    }
}