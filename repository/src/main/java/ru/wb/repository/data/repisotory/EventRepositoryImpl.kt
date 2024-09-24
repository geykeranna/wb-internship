package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.EventData
import ru.wb.domain.repository.ResultResponse
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventResponse
import kotlin.random.Random

internal class EventRepositoryImpl: EventRepository {
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
    ): Flow<EventData> {
        return flowOf(EventData.defaultObject)
    }

    override fun subscribeOnEvent(idUser: String, idEvent: String): Flow<ResultResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> ResultResponse.SUCCESS
                else -> ResultResponse.ERROR
            }
        )
    }
}