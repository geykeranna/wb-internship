package ru.testtask.testapplication.domain.repisotory

interface LoginRepository {

    suspend fun sendCode(phoneNumber: String)

    suspend fun getPhoneAuth(): String

    suspend fun getAuthState(): Boolean

    suspend fun getUserID(): String
}