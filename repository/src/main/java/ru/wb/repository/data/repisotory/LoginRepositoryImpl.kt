package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.LoginRepository
import ru.wb.domain.model.UserData

internal class LoginRepositoryImpl: LoginRepository {
    override fun checkCode(pinCode: String): Flow<Boolean> {
        return flowOf(true)
    }

    override fun sendOnPhone(phoneNumber: String): Flow<Boolean> {
        return flowOf(true)
    }

    override fun getPhoneAuth(): Flow<String> {
        return flowOf(UserData.defaultObject.phone)
    }

    override  fun getAuthState(): Flow<Boolean> {
        return flowOf(UserData.defaultObject.id.isNotEmpty())
    }

    override fun getUserID(): Flow<String> {
        return flowOf(UserData.defaultObject.id)
    }
}