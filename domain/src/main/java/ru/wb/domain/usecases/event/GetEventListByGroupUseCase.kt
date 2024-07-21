package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository

class GetEventListByGroupUseCase(private val repository: EventRepository) {
    suspend fun execute(query: String? = null, userId: String? = null): List<EventsByGroup>{
        return repository.getEventsByGroup(
            query = query,
            userId = userId
        )
    }
}