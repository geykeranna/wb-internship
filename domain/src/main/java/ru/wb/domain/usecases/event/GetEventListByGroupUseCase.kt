package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

interface GetEventListByGroupUseCase {
    suspend fun execute(userId: String? = null,
                        date: String? = null
    ): Flow<List<EventsByGroup>>
}