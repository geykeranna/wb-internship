package ru.wb.domain.stabs

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

internal class EventRepositoryStabs: EventRepository {
    override suspend fun getEvents(
        data: EventGetRequest?,
    ): List<EventData> = listOf(EventData.defaultObject)

    override suspend fun getEvent(
        id: String,
    ): EventData = EventData.defaultObject
}