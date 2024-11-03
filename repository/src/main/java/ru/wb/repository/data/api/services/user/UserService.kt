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
        @Path("id") eventId: String
    ): Boolean

    @GET("/user/event/{id}")
    suspend fun getUserInEvent(
        @Path("id") eventId: String
    ): Boolean

    @POST("/user/community/{id}")
    suspend fun setUserInCommunity(
        @Path("id") communityId: String
    ): Boolean

    @GET("/user/community/{id}")
    suspend fun getUserInCommunity(
        @Path("id") communityId: String
    ): Boolean
}