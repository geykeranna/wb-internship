package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.model.UserData

internal class LoginRepositoryImpl: LoginRepository {
    override suspend fun checkCode(pinCode: String): Flow<Boolean> {
        return flowOf(false)
    }

    override suspend fun sendOnPhone(phoneNumber: String): Flow<Boolean> {
        return flowOf(true)
    }

    override suspend fun getPhoneAuth(): Flow<String> {
        return flowOf(UserData.defaultObject.phone)
    }

    override suspend fun getAuthState(): Flow<Boolean> {
        return flowOf(UserData.defaultObject.id.isNotEmpty())
    }

    override suspend fun getUserID(): Flow<String> {
        return flowOf(UserData.defaultObject.id)
    }
}