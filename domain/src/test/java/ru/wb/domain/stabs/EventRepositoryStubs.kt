package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.EventData
import ru.wb.domain.model.Location
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventResponse

internal class EventRepositoryStubs: EventRepository {
    private val eventData = EventData(
        id = "1",
        name = "Event",
        location = Location.defaultObject,
        date = "",
        tagList = listOf(),
        icon = null,
        active = true,
        description = "description",
        usersList = mutableListOf(),
        vacantSeat = 10,
        sponsor = CommunityData.defaultObject,
        manager = UserData.defaultObject,
    )

    override fun getEvents(
        data: EventGetRequest?,
    ): Flow<EventResponse>{
        val response = EventResponse(
            limit = 10,
            offset = 0,
            data = List(10) { EventData.defaultObject }
        )
        return flowOf(response)
    }

    override fun getEvent(
        id: String,
    ): Flow<EventData> = flowOf(eventData)

    override fun subscribeOnEvent(idUser: String, idEvent: String): Flow<Boolean> {
        return flowOf(true)
    }
}