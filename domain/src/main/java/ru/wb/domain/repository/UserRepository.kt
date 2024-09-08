package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.model.UsersGetRequest

interface UserRepository {
    fun getUsers(data: UsersGetRequest? = null): Flow<List<UserData>>

    fun getUser(id: String?): Flow<UserData>

    fun getUserAuth(): Flow<String?>

    fun putUser(userData: UserData): Flow<UserData?>

    fun postUser(userData: UserData): Flow<UserData?>

    fun changeSubscriptionEventStatus(eventID: String): Flow<Boolean>

    fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean>

    fun getSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean>

    fun getSubscriptionEventStatus(idEvent: String): Flow<Boolean>
}