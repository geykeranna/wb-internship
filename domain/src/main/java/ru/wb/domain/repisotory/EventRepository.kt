package ru.wb.domain.repisotory

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.model.EventGetRequest

interface EventRepository {
    suspend fun getEvents(data: EventGetRequest? = null): List<EventData>

    suspend fun getEvent(id: String): EventData
}