package ru.wb.domain.stabs

import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.model.UserData

internal class LoginRepositoryStubs: LoginRepository {
    override suspend fun checkCode(pinCode: String) = flowOf(true)

    override suspend fun sendOnPhone(phoneNumber: String) = flowOf("+79099099900" == phoneNumber)

    override suspend fun getPhoneAuth() = flowOf("+79099099900")

    override suspend fun getAuthState() = flowOf(false)

    override suspend fun getUserID() = flowOf("101")
}