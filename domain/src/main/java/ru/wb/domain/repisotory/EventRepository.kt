package ru.wb.domain.repisotory

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.model.EventGetRequest

interface EventRepository {
    suspend fun getEvents(data: EventGetRequest? = null): Flow<List<EventData>>

    suspend fun getEvent(id: String): Flow<EventData>
}