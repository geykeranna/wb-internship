package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun sendOnPhone(phoneNumber: String): Flow<Boolean>

    fun checkCode(pinCode: String): Flow<Boolean>

    fun getPhoneAuth(): Flow<String>

    fun getAuthState(): Flow<Boolean>

    fun getUserID(): Flow<String>
}