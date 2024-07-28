package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.model.Location
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

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
        usersList = mutableListOf()
    )

    override suspend fun getEvents(
        data: EventGetRequest?,
    ): Flow<List<EventData>> {
        data?.limit?.let {
            return flowOf(List (it) { eventData })
        }
        return flowOf(listOf(eventData))
    }

    override suspend fun getEvent(
        id: String,
    ): Flow<EventData> = flowOf(eventData)
}