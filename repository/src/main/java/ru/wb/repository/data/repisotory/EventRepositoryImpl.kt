package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

internal class EventRepositoryImpl: EventRepository {
    override suspend fun getEvents(
        data: EventGetRequest?,
    ): Flow<List<EventData>>{
        return flowOf(listOf(EventData.defaultObject))
    }

    override suspend fun getEvent(
        id: String,
    ): Flow<EventData> {
        return flowOf(EventData.defaultObject)
    }
}