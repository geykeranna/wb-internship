package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.repository.data.model.EventData
import ru.testtask.testapplication.repository.data.model.EventsByGroup

interface EventRepository {
    suspend fun getEvents(): List<EventData>

    suspend fun getEventsByGroup(): List<EventsByGroup>

    suspend fun getEvent(id: String): EventData
}