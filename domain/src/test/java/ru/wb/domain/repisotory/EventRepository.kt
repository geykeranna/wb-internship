package ru.wb.domain.repisotory

import ru.wb.domain.model.EventData

data class EventGetRequest(
    val limit: String? = null,
    val offset: String? = null,
    val query: String? = null,
    val userId: String? = null,
    val state: String? = null,
)

interface EventRepository {
    suspend fun getEvents(data: EventGetRequest): List<EventData>

    suspend fun getEvent(id: String): EventData
}