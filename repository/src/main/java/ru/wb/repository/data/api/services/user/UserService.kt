package ru.wb.repository.data.api.services.user

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import ru.wb.repository.data.api.model.User

internal interface UserService {
    @GET("/user")
    suspend fun getUsers(
        @Body data: UserGetRequest?
    ): UserGetResponse

    @GET("/user/{id}")
    suspend fun getUser(
        @Path("id") id: String
    ): User

    @PUT("/user/{id}")
    suspend fun putUser(
        @Path("id") id: String,
        @Body userData: User
    ): User?

    @POST("/user")
    suspend fun postUser(
        @Body userData: User
    ): User?

    @DELETE("/user/{id}")
    suspend fun deleteUser(
        @Path("id") id: String,
    ): Boolean

    @POST("/user/event/{id}")
    suspend fun setUserInEvent(
        @Path("event_id") eventId: String,
        @Path("user_id") userId: String,
    ): Boolean

    @GET("/user/event/{id}")
    suspend fun getUserInEvent(
        @Path("event_id") eventId: String,
        @Path("user_id") userId: String,
    ): Boolean

    @POST("/user/community/{id}")
    suspend fun setUserInCommunity(
        @Path("community_id") communityId: String,
        @Path("user_id") userId: String,
    ): Boolean

    @GET("/user/community/{id}")
    suspend fun getUserInCommunity(
        @Path("community_id") communityId: String,
        @Path("user_id") userId: String,
    ): Boolean
}