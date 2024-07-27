package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData

interface GetEventListUseCase {
    suspend fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        userId: String? = null,
        state: String? = null,
    ): List<EventData>
}