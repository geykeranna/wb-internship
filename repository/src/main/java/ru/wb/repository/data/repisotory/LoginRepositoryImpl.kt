package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.LoginRepository
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState

internal class LoginRepositoryImpl: LoginRepository {
    override fun checkCode(pinCode: String): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("local"))
    }

    override fun sendOnPhone(phoneNumber: String): Flow<LoadState<Boolean>> {
        return flowOf(LoadState.Success(true))
    }

    override fun getPhoneAuth(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("89099099900"))
    }

    override  fun getAuthState(): Flow<LoadState<Boolean>> {
        return flowOf(LoadState.Success(UserData.defaultObject.id.isNotEmpty()))
    }

    override fun getUserID(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success(UserData.defaultObject.id))
    }
}