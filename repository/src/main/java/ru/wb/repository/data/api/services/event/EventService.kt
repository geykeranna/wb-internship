package ru.wb.repository.data.api.services.event

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import ru.wb.repository.data.api.model.Event

internal interface EventService {
    @GET("/event")
    suspend fun getEvents(
        @Body data: EventGetRequest? = null
    ): EventGetResponse

    @GET("/event/{id}")
    suspend fun getEvent(
        @Path("id") id: String
    ): Event
}