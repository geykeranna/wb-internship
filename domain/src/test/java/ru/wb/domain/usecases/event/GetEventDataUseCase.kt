package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository

internal class GetEventDataUseCaseImpl(
    private val repository: EventRepository
) : GetEventDataUseCase {
    override suspend fun execute(id: String): EventData = repository.getEvent(id = id)
}

interface GetEventDataUseCase {
    suspend fun execute(id: String): EventData
}