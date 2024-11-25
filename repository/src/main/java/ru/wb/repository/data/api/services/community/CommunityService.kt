package ru.wb.repository.data.api.services.community

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import ru.wb.repository.data.api.model.Community

internal interface CommunityService {
    @GET("/community/{id}")
    fun getCommunity(
        @Path("id") id: String
    ): Community?

    @GET("/community")
    fun getCommunities(
        @Body data: CommunityGetRequest?
    ): CommunityGetResponse
}