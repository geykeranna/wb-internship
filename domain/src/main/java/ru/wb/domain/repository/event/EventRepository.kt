package ru.wb.domain.repository.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState

interface EventRepository {
    fun getEvents(request: EventGetRequest? = null): Flow<LoadState<EventGetResponse>>

    fun getEvent(id: String): Flow<LoadState<EventData>>
}