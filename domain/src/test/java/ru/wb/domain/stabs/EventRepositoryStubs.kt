package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.model.EventItemData
import ru.wb.domain.model.Location
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventGetResponse

internal class EventRepositoryStubs: EventRepository {
    private val eventItemData = EventItemData(
        id = "1",
        name = "Event",
        location = Location.defaultObject,
        date = "",
        tagList = listOf(),
        icon = null,
        active = true,
        description = "description",
        vacantSeat = 10,
    )

    private val eventsData = EventData(
        id = "1",
        name = "Event",
        location = Location.defaultObject,
        date = "",
        tagList = listOf(),
        icon = null,
        active = true,
        description = "description",
        vacantSeat = 10,
    )

    override fun getEvents(
        request: EventGetRequest?,
    ): Flow<LoadState<EventGetResponse>>{
        val response = EventGetResponse(
            limit = 10,
            offset = 0,
            data = List(10) { eventItemData }
        )
        return flowOf(LoadState.Success(response))
    }

    override fun getEvent(
        id: String,
    ): Flow<LoadState<EventData>> {
        return flowOf(LoadState.Success(eventsData) as LoadState<EventData>)
    }
}