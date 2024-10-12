package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.LoginRepository

internal class LoginRepositoryStubs: LoginRepository {
    override fun checkCode(pinCode: String): Flow<LoadState<String>> =
        flowOf(LoadState.Success("local"))

    override fun sendOnPhone(phoneNumber: String): Flow<LoadState<Boolean>> =
        flowOf(LoadState.Success("+79099099900" == phoneNumber))

    override fun getPhoneAuth(): Flow<LoadState<String>> =
        flowOf(LoadState.Success("+79099099900"))

    override fun getAuthState(): Flow<LoadState<Boolean>> =
        flowOf(LoadState.Success(false))

    override fun getUserID(): Flow<LoadState<String>> =
        flowOf(LoadState.Success("101"))
}