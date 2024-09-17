package ru.wb.domain.repository.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData

interface EventRepository {
    fun getEvents(data: EventGetRequest? = null): Flow<EventResponse>

    fun getEvent(id: String): Flow<EventData>

    fun subscribeOnEvent(idUser: String, idEvent: String): Flow<Boolean>
}