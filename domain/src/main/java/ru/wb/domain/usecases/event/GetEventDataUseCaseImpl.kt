package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository

internal class GetEventDataUseCaseImpl(
    private val repository: EventRepository
) : GetEventDataUseCase {
    override fun execute(id: String): Flow<LoadState<EventData>> = repository.getEvent(id = id)
}