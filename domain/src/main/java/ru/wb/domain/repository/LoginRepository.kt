package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface LoginRepository {
    fun sendOnPhone(phoneNumber: String): Flow<LoadState<Boolean>>

    fun checkCode(pinCode: String): Flow<LoadState<Boolean>>

    fun getAuthState(): Flow<LoadState<Boolean>>
}