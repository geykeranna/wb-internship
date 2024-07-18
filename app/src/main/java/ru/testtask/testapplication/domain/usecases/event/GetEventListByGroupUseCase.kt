package ru.testtask.testapplication.domain.usecases.event

import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.domain.repisotory.EventRepository

class GetEventListByGroupUseCase(private val repository: EventRepository) {
    suspend fun execute(): List<EventsByGroup> = repository.getEventsByGroup()
}