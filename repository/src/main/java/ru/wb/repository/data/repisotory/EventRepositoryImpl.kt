package ru.wb.repository.data.repisotory

import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.EventGetRequest

internal class EventRepositoryImpl: EventRepository {
    override suspend fun getEvents(
        data: EventGetRequest,
    ): List<EventData> = listOf(EventData.defaultObject)

    override suspend fun getEvent(
        id: String,
    ): EventData = EventData.defaultObject
}