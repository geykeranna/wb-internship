package ru.testtask.testapplication.data.repisotory

import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.LoginRepository

class LoginRepositoryImpl: LoginRepository {
    override suspend fun sendCode(phoneNumber: String) { }

    override suspend fun getPhoneAuth(): String = UserData.shimmerData.phone

    override suspend fun getAuthState(): Boolean = UserData.shimmerData.status
}