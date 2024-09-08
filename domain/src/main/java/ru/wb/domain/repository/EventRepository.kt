package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.repository.model.EventGetRequest

interface EventRepository {
    fun getEvents(data: EventGetRequest? = null): Flow<List<EventData>>

    fun getEvent(id: String): Flow<EventData>

    fun subscribeOnEvent(idUser: String, idEvent: String): Flow<Boolean>
}