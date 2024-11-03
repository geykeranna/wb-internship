package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.Errors
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.repository.user.UsersGetRequest
import ru.wb.repository.data.api.mappers.models.UserMapper
import ru.wb.repository.data.api.mappers.request.UsersGetRequestMapper
import ru.wb.repository.data.api.mappers.response.UserGetResponseMapper
import ru.wb.repository.data.api.services.user.UserService
import ru.wb.repository.data.sharedpreferences.user.SharedPrefUserStorage

internal class UserRepositoryImpl(
    private val api: UserService,
    private val sharedPrefStorage: SharedPrefUserStorage,
    private val userMapper: UserMapper,
    private val userGetResponseMapper: UserGetResponseMapper,
    private val usersGetRequestMapper: UsersGetRequestMapper,
): UserRepository {
    override fun getUsers(request: UsersGetRequest?): Flow<LoadState<UserResponse>> {
        return flow {
            val response = api.getUsers(request?.let {
                usersGetRequestMapper.transformToRepository(data = request)
            })
            val loadState = LoadState.Success(userGetResponseMapper.transformToDomain(response))
            emit(loadState as LoadState<UserResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getUser(id: String?): Flow<LoadState<UserData>> {
        return flow {
            var response: UserData
            id?.let { idUser ->
                response = userMapper.transformToDomain(api.getUser(idUser))
                emit(LoadState.Success(response) as LoadState<UserData>)
            }
            emit(LoadState.Success(UserData.defaultObject))
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getUserAuth(): Flow<LoadState<String?>> {
        return flow {
            emit(LoadState.Success(UserData.defaultObject.id) as LoadState<String?>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.DATABASE_ERROR))
        }
    }

    override fun putUser(userData: UserData): Flow<LoadState<UserData?>>{
        return flow {
            val response = api.putUser(
                id = userData.id,
                userData = userMapper.transformToRepository(userData)
            )?.let { userMapper.transformToDomain(it) }
            emit(LoadState.Success(response) as LoadState<UserData?>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun postUser(userData: UserData): Flow<LoadState<UserData?>> {
        return flow {
            val response = api.postUser(
                userData = userMapper.transformToRepository(userData)
            )?.let { userMapper.transformToDomain(it) }
            emit(LoadState.Success(response) as LoadState<UserData?>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getNameUser(): Flow<LoadState<String>> {
        return flow {
            val userName = UserData.defaultObject.name
            emit(LoadState.Success(userName) as LoadState<String>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun setNameUser(name: String): Flow<LoadState<UserData>> {
        return flow {
            val user = api.getUser("local").copy(name = name)
            api.putUser(
                id = "local",
                userData = user
            )?.let {
                val userData = userMapper.transformToDomain(it)
                emit(LoadState.Success(userData) as LoadState<UserData>)
            }
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getPhoneUser(): Flow<LoadState<String>> {
        return flow {
            val userPhone = UserData.defaultObject.phone
            emit(LoadState.Success(userPhone) as LoadState<String>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun setPhoneUser(phone: String): Flow<LoadState<UserData>> {
        return flow {
            val user = api.getUser("local").copy(phone = phone)
            api.putUser(
                id = "local",
                userData = user
            )?.let {
                val userData = userMapper.transformToDomain(it)
                emit(LoadState.Success(userData) as LoadState<UserData>)
            }
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun deleteUser(): Flow<LoadState<Boolean>> {
        return flow {
            val id = sharedPrefStorage.getValue()
            if(id.isNotBlank()) { api.deleteUser(id = id) }
            emit(LoadState.Success(id.isBlank()) as LoadState<Boolean>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun changeSubscriptionEventStatus(eventID: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        return flow {
            val response = api.setUserInEvent(eventId = eventID)
            val status = when(response) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
            emit(LoadState.Success(status) as LoadState<UserSubscribeStatusResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        return flow {
            val response = api.setUserInCommunity(communityId = idCommunity)
            val status = when(response) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
            emit(LoadState.Success(status) as LoadState<UserSubscribeStatusResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        return flow {
            val response = api.getUserInCommunity(communityId = idCommunity)
            val status = when(response) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
            emit(LoadState.Success(status) as LoadState<UserSubscribeStatusResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }

    override fun getSubscriptionEventStatus(idEvent: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        return flow {
            val response = api.getUserInEvent(eventId = idEvent)
            val status = when(response) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
            emit(LoadState.Success(status) as LoadState<UserSubscribeStatusResponse>)
        }.onStart {
            emit(LoadState.Loading)
        }.catch {
            emit(LoadState.Error(Errors.NETWORK_ERROR))
        }
    }
}