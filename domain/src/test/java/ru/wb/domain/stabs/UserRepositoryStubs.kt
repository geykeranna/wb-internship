package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserResponse
import ru.wb.domain.repository.user.UsersGetRequest

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

    override fun getUsers(data: UsersGetRequest?): Flow<UserResponse> {
        val response = UserResponse(
            limit = 10,
            offset = 0,
            data = List(10) { UserData.defaultObject }
        )
        return flowOf(response)
    }

    override fun getUser(id: String?) = flowOf(userData)

    override fun getUserAuth(): Flow<String?> {
        return flowOf(null)
    }

    override fun putUser(userData: UserData) = flowOf(userData)

    override fun postUser(userData: UserData) = flowOf(userData)

    override fun changeSubscriptionEventStatus(eventID: String) = flowOf(true)

    override fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean> = flowOf(true)

    override fun getSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean> = flowOf(true)

    override fun getSubscriptionEventStatus(idEvent: String): Flow<Boolean> {
        return flowOf(false)
    }
}