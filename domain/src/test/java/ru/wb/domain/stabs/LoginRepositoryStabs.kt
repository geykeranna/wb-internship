package ru.wb.domain.stabs

import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.model.UserData

internal class LoginRepositoryStabs: LoginRepository {
    override suspend fun checkCode(pinCode: String) = true

    override suspend fun sendOnPhone(phoneNumber: String) = true

    override suspend fun getPhoneAuth(): String = UserData.defaultObject.phone.orEmpty()

    override suspend fun getAuthState(): Boolean = UserData.defaultObject.id.isNotEmpty()

    override suspend fun getUserID(): String = UserData.defaultObject.id
}