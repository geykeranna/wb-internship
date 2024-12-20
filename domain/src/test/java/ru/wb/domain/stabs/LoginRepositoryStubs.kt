package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.LoginRepository

internal class LoginRepositoryStubs: LoginRepository {
    override fun checkCode(pinCode: String): Flow<LoadState<Boolean>> =
        flowOf(LoadState.Success(true))

    override fun sendOnPhone(phoneNumber: String): Flow<LoadState<Boolean>> =
        flowOf(LoadState.Success("+79099099900" == phoneNumber))

    override fun getAuthState(): Flow<LoadState<Boolean>> =
        flowOf(LoadState.Success(false))
}