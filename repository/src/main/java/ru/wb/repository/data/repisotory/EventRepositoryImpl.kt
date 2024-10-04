package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventResponse
import kotlin.random.Random

internal class EventRepositoryImpl: EventRepository {
    override fun getEvents(
        data: EventGetRequest?,
    ): Flow<LoadState<EventResponse>>{
        val response = EventResponse(
            limit = 10,
            offset = 0,
            data = List(10) { EventData.defaultObject }
        )
        return flowOf(LoadState.Success(response))
    }

    override fun getEvent(
        id: String,
    ): Flow<LoadState<EventData>> {
        return flowOf(LoadState.Success(EventData.defaultObject))
    }

    override fun subscribeOnEvent(idUser: String, idEvent: String): Flow<LoadState<Boolean>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(LoadState.Success(random))
    }
}