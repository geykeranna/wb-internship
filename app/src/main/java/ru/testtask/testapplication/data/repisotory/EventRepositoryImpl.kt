package ru.testtask.testapplication.data.repisotory

import ru.testtask.testapplication.data.model.EventData
import ru.testtask.testapplication.data.model.EventsByGroup
import ru.testtask.testapplication.domain.repisotory.EventRepository

class EventRepositoryImpl: EventRepository {
    override suspend fun getEvents(): List<EventData> = List(10) { EventData.shimmerData1 }

    override suspend fun getEventsByGroup(): List<EventsByGroup> = EventsByGroup.shimmerDataList1

    override suspend fun getEvent(id: String): EventData = EventData.shimmerData1
}