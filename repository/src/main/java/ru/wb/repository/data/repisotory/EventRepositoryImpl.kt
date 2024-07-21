package ru.wb.repository.data.repisotory

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.model.EventsByGroup

class EventRepositoryImpl: EventRepository {
    override suspend fun getEvents(
        query: String?,
        userId: String?,
        state: String?
    ): List<EventData> = listOf(EventData.defaultObject)

    override suspend fun getEventsByGroup(
        query: String?,
        userId: String?
    ): List<EventsByGroup> = EventsByGroup.defaultObject

    override suspend fun getEvent(id: String): EventData = EventData.defaultObject
}