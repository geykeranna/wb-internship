package ru.testtask.testapplication.domain.usecases.event

import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.domain.repisotory.EventRepository

class GetEventDataUseCase(private val repository: EventRepository) {
    suspend fun execute(id: String): EventData = repository.getEvent(id = id)
}