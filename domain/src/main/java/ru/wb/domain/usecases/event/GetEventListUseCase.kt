package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData

interface GetEventListUseCase {
    fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        userId: String? = null,
        state: String? = null,
        startDate: String? = null,
        endDate: String? = null,
    ): Flow<List<EventData>>
}