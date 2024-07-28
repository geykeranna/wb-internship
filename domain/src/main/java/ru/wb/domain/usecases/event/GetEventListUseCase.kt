package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData

interface GetEventListUseCase {
    suspend fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        userId: String? = null,
        state: String? = null,
    ): Flow<List<EventData>>
}