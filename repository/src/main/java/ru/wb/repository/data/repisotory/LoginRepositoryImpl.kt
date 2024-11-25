package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import ru.wb.domain.model.components.Errors
import ru.wb.domain.repository.LoginRepository
import ru.wb.domain.model.components.LoadState
import ru.wb.repository.data.api.services.login.LoginService
import ru.wb.repository.data.sharedpreferences.login.SharedPrefLoginStorage

internal class LoginRepositoryImpl(
    private val api: LoginService,
    private val sharedPrefStorage: SharedPrefLoginStorage,
): LoginRepository {
    override fun checkCode(pinCode: String): Flow<LoadState<Boolean>> {
        return flow {
            val newToken = api.getVerifyOTPCode(pinCode)
            sharedPrefStorage.saveValue(newToken)
            emit(LoadState.Success(newToken.isBlank()) as LoadState<Boolean>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun sendOnPhone(phoneNumber: String): Flow<LoadState<Boolean>> {
        return flow {
            api.postOTPCode(phoneNumber = phoneNumber)
            emit(LoadState.Success(true) as LoadState<Boolean>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getAuthState(): Flow<LoadState<Boolean>> {
        return flow {
            val token = sharedPrefStorage.getValue()
            val request = api.getAuthState(token)
            emit(LoadState.Success(request) as LoadState<Boolean>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }
}