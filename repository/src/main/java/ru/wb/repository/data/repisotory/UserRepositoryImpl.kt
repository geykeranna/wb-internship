package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.repository.user.UsersGetRequest
import kotlin.random.Random

internal class UserRepositoryImpl: UserRepository {
    override fun getUsers(data: UsersGetRequest?): Flow<LoadState<UserResponse>> {
        val response = UserResponse(
            limit = 10,
            offset = 0,
            data = List(10) { UserData.defaultObject }
        )
        return flowOf(LoadState.Success(response))
    }

    override fun getUser(id: String?): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(UserData.defaultObject))
    }

    override fun getUserAuth(): Flow<LoadState<String?>> {
        return flowOf(LoadState.Success(null))
    }

    override fun putUser(userData: UserData): Flow<LoadState<UserData?>>{
        return flowOf(LoadState.Success(UserData.defaultObject))
    }

    override fun postUser(userData: UserData): Flow<LoadState<UserData?>> {
        return flowOf(LoadState.Success(UserData.defaultObject))
    }

    override fun getNameUser(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("Name"))
    }

    override fun setNameUser(name: String): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(UserData.defaultObject))
    }

    override fun getPhoneUser(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("+79099099900"))
    }

    override fun setPhoneUser(phone: String): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(UserData.defaultObject))
    }

    override fun deleteUser(): Flow<LoadState<Boolean>> {
        return flowOf(LoadState.Success(data = false))
    }

    override fun changeSubscriptionEventStatus(eventID: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> LoadState.Success(UserSubscribeStatusResponse.SUBSCRIBED)
                else -> LoadState.Success(UserSubscribeStatusResponse.NOT_SUBSCRIBED)
            }
        )
    }

    override fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> LoadState.Success(UserSubscribeStatusResponse.SUBSCRIBED)
                else -> LoadState.Success(UserSubscribeStatusResponse.NOT_SUBSCRIBED)
            }
        )
    }

    override fun getSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> LoadState.Success(UserSubscribeStatusResponse.SUBSCRIBED)
                else -> LoadState.Success(UserSubscribeStatusResponse.NOT_SUBSCRIBED)
            }
        )
    }

    override fun getSubscriptionEventStatus(idEvent: String): Flow<LoadState<UserSubscribeStatusResponse>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> LoadState.Success(UserSubscribeStatusResponse.SUBSCRIBED)
                else -> LoadState.Success(UserSubscribeStatusResponse.NOT_SUBSCRIBED)
            }
        )
    }
}