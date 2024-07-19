package ru.testtask.testapplication.domain.usecases.event

import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.domain.repisotory.EventRepository

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