package ru.wb.domain.stabs

import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.LoginRepository

internal class LoginRepositoryStubs: LoginRepository {
    override fun checkCode(pinCode: String) = flowOf(true)

    override fun sendOnPhone(phoneNumber: String) = flowOf("+79099099900" == phoneNumber)

    override fun getPhoneAuth() = flowOf("+79099099900")

    override fun getAuthState() = flowOf(false)

    override fun getUserID() = flowOf("101")
}