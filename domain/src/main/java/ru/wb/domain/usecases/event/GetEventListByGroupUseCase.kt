package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

interface GetEventListByGroupUseCase {
    suspend fun execute(userId: String? = null,
                        date: String? = null
    ): List<EventsByGroup>
}