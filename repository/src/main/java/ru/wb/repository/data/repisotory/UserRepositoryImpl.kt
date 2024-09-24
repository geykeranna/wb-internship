package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.domain.repository.user.UsersGetRequest
import kotlin.random.Random

internal class UserRepositoryImpl: UserRepository {
    override fun getUsers(data: UsersGetRequest?): Flow<UserResponse> {
        val response = UserResponse(
            limit = 10,
            offset = 0,
            data = List(10) { UserData.defaultObject }
        )
        return flowOf(response)
    }

    override fun getUser(id: String?): Flow<UserData> {
        return flowOf(UserData.defaultObject)
    }

    override fun getUserAuth(): Flow<String?> {
        return flowOf(null)
    }

    override fun putUser(userData: UserData): Flow<UserData?>{
        return flowOf(UserData.defaultObject)
    }

    override fun postUser(userData: UserData): Flow<UserData?> {
        return flowOf(UserData.defaultObject)
    }

    override fun changeSubscriptionEventStatus(eventID: String): Flow<UserSubscribeStatusResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
        )
    }

    override fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<UserSubscribeStatusResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
        )
    }

    override fun getSubscriptionCommunityStatus(idCommunity: String): Flow<UserSubscribeStatusResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
        )
    }

    override fun getSubscriptionEventStatus(idEvent: String): Flow<UserSubscribeStatusResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> UserSubscribeStatusResponse.SUBSCRIBED
                else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
            }
        )
    }
}