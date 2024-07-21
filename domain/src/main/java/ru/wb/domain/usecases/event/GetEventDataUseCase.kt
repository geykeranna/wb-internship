package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository

class GetEventDataUseCase(private val repository: EventRepository) {
    suspend fun execute(id: String): EventData = repository.getEvent(id = id)
}