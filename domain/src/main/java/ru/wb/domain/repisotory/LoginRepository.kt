package ru.wb.domain.repisotory

import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun sendOnPhone(phoneNumber: String): Flow<Boolean>

    suspend fun checkCode(pinCode: String): Flow<Boolean>

    suspend fun getPhoneAuth(): Flow<String>

    suspend fun getAuthState(): Flow<Boolean>

    suspend fun getUserID(): Flow<String>
}