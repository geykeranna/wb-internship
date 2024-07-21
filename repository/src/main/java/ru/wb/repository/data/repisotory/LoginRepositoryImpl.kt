package ru.wb.repository.data.repisotory

import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.model.UserData

class LoginRepositoryImpl: LoginRepository {
    override suspend fun sendCode(pinCode: String) = Unit

    override suspend fun setPhone(phoneNumber: String) = Unit

    override suspend fun getPhoneAuth(): String = UserData.defaultObject.phone ?: ""

    override suspend fun getAuthState(): Boolean = !UserData.defaultObject.id.isNullOrEmpty()

    override suspend fun getUserID(): String = UserData.defaultObject.id ?: ""
}