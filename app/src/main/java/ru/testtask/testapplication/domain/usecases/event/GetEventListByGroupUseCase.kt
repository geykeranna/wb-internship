package ru.testtask.testapplication.domain.usecases.event

import ru.testtask.testapplication.repository.data.model.EventsByGroup
import ru.testtask.testapplication.domain.repisotory.EventRepository

class GetEventListByGroupUseCase(private val repository: EventRepository) {
    suspend fun execute(query: String? = null, userId: String? = null): List<EventsByGroup>{
        return repository.getEventsByGroup(
            query = query,
            userId = userId
        )
    }
}