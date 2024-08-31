package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.model.UsersGetRequest

interface UserRepository {
    fun getUsers(data: UsersGetRequest? = null): Flow<List<UserData>>

    fun getUser(id: String): Flow<UserData>

    fun putUser(userData: UserData): Flow<Boolean>

    fun postUser(userData: UserData): Flow<Boolean>

    fun handleGoingEvent(eventID: String): Flow<Boolean>

    fun changeSubscriptionStatus(idCommunity: String): Flow<Boolean>

    fun getSubscriptionStatus(idCommunity: String): Flow<Boolean>
}