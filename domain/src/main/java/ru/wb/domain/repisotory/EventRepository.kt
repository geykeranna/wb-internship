package ru.wb.domain.repisotory

import ru.wb.domain.model.EventData
import ru.wb.domain.model.EventsByGroup

interface EventRepository {
    suspend fun getEvents(query: String?, userId: String?, state: String?): List<EventData>

    suspend fun getEventsByGroup(query: String?, userId: String?): List<EventsByGroup>

    suspend fun getEvent(id: String): EventData
}