package ru.wb.domain.repository.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData

interface UserRepository {
    fun getUsers(data: UsersGetRequest? = null): Flow<UserResponse>

    fun getUser(id: String?): Flow<UserData>

    fun getUserAuth(): Flow<String?>

    fun putUser(userData: UserData): Flow<UserData?>

    fun postUser(userData: UserData): Flow<UserData?>

    fun changeSubscriptionEventStatus(eventID: String): Flow<UserSubscribeStatusResponse>

    fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<UserSubscribeStatusResponse>

    fun getSubscriptionCommunityStatus(idCommunity: String): Flow<UserSubscribeStatusResponse>

    fun getSubscriptionEventStatus(idEvent: String): Flow<UserSubscribeStatusResponse>
}