package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData

interface GetEventDataUseCase {
    suspend fun execute(id: String): Flow<EventData>
}