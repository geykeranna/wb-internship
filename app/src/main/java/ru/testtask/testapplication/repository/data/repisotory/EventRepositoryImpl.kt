package ru.testtask.testapplication.repository.data.repisotory

import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.repository.data.model.EventsByGroup
import ru.testtask.testapplication.domain.repisotory.EventRepository

class EventRepositoryImpl: EventRepository {
    override suspend fun getEvents(query: String?, userId: String?, state: String?): List<EventData> = List(10) { EventData.shimmerData1 }

    override suspend fun getEventsByGroup(query: String?, userId: String?): List<EventsByGroup> = EventsByGroup.shimmerDataList1

    override suspend fun getEvent(id: String): EventData = EventData.shimmerData1
}