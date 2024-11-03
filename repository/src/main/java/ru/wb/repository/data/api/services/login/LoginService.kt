package ru.wb.repository.data.api.services.login

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

internal interface LoginService {
    @POST("/login/auth")
    suspend fun postOTPCode(
        @Body phoneNumber: String,
    ): String

    @GET("/login/auth")
    suspend fun getVerifyOTPCode(
        @Query("pin_code") pinCode: String
    ): String

    @GET("/login/auth")
    suspend fun getAuthState(
        @Query("token") token: String
    ): Boolean
}