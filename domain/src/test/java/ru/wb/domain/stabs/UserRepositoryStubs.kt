package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.repository.user.UsersGetRequest
import kotlin.random.Random

internal class UserRepositoryStubs: UserRepository {
    private val userData = UserData(
        id = "1",
        name = "Name",
        icon = null,
        story = false,
        status = false,
        phone = "0000000000",
        socialMedia = listOf()
    )

    override fun getUsers(request: UsersGetRequest?): Flow<LoadState<UserResponse>> {
        val response = UserResponse(
            limit = 10,
            offset = 0,
            data = List(10) { userData }
        )
        return flowOf(LoadState.Success(response))
    }

    override fun getUser(id: String?): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(userData))
    }

    override fun getNameUser(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("Name"))
    }

    override fun setNameUser(name: String): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(userData))
    }

    override fun getPhoneUser(): Flow<LoadState<String>> {
        return flowOf(LoadState.Success("+79099099900"))
    }

    override fun setPhoneUser(phone: String): Flow<LoadState<UserData>> {
        return flowOf(LoadState.Success(userData))
    }

    override fun getUserAuth(): Flow<LoadState<String?>> {
        return flowOf(LoadState.Success(null))
    }

    override fun putUser(userData: UserData): Flow<LoadState<UserData?>>{
        return flowOf(LoadState.Success(userData))
    }

    override fun postUser(userData: UserData): Flow<LoadState<UserData?>> {
        return flowOf(LoadState.Success(userData))
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