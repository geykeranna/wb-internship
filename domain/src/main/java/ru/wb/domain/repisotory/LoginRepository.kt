package ru.wb.domain.repisotory

interface LoginRepository {

    suspend fun sendOnPhone(phoneNumber: String): Boolean

    suspend fun checkCode(pinCode: String): Boolean

    suspend fun getPhoneAuth(): String

    suspend fun getAuthState(): Boolean

    suspend fun getUserID(): String
}