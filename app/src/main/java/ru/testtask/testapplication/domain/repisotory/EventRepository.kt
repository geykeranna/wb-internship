package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.repository.data.model.EventsByGroup

interface EventRepository {
    suspend fun getEvents(query: String?, userId: String?, state: String?): List<EventData>

    suspend fun getEventsByGroup(query: String?, userId: String?): List<EventsByGroup>

    suspend fun getEvent(id: String): EventData
}