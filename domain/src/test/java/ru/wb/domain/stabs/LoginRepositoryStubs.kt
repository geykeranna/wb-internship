package ru.wb.domain.stabs

import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.model.UserData

internal class LoginRepositoryStubs: LoginRepository {
    override suspend fun checkCode(pinCode: String) = true

    override suspend fun sendOnPhone(phoneNumber: String) = "+79099099900" == phoneNumber

    override suspend fun getPhoneAuth(): String = "+79099099900"

    override suspend fun getAuthState(): Boolean = false

    override suspend fun getUserID(): String = "101"
}