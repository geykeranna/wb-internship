package ru.wb.domain.repository.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState

interface EventRepository {
    fun getEvents(data: EventGetRequest? = null): Flow<LoadState<EventResponse>>

    fun getEvent(id: String): Flow<LoadState<EventData>>

    fun subscribeOnEvent(idUser: String, idEvent: String) : Flow<LoadState<Boolean>>
}