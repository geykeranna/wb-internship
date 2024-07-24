package ru.wb.domain.repisotory

interface LoginRepository {

    suspend fun setPhone(phoneNumber: String)

    suspend fun sendCode(pinCode: String)

    suspend fun getPhoneAuth(): String

    suspend fun getAuthState(): Boolean

    suspend fun getUserID(): String
}