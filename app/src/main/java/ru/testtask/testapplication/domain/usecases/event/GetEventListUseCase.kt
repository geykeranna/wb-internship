package ru.testtask.testapplication.domain.usecases.event

import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.domain.repisotory.EventRepository

class GetEventListUseCase(private val repository: EventRepository) {
    suspend fun execute(): List<EventData> = repository.getEvents()
}