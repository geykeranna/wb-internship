package ru.testtask.testapplication.repository.data.repisotory

import ru.testtask.testapplication.domain.repisotory.LoginRepository
import ru.testtask.testapplication.repository.data.model.UserData

class LoginRepositoryImpl: LoginRepository {
    override suspend fun sendCode(pinCode: String) = Unit

    override suspend fun setPhone(phoneNumber: String) = Unit

    override suspend fun getPhoneAuth(): String = UserData.shimmerData.phone ?: ""

    override suspend fun getAuthState(): Boolean = !UserData.shimmerData.id.isNullOrEmpty()

    override suspend fun getUserID(): String = UserData.shimmerData.id ?: ""
}