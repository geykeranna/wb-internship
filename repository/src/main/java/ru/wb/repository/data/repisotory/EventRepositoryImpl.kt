package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.repository.EventRepository
import ru.wb.domain.repository.model.EventGetRequest

internal class EventRepositoryImpl: EventRepository {
    override fun getEvents(
        data: EventGetRequest?,
    ): Flow<List<EventData>>{
        return flowOf(List(10) { EventData.defaultObject })
    }

    override fun getEvent(
        id: String,
    ): Flow<EventData> {
        return flowOf(EventData.defaultObject)
    }

    override fun subscribeOnEvent(idUser: String, idEvent: String): Flow<Boolean> {
        return flowOf(true)
    }
}