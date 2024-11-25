package ru.wb.domain.repository.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.model.components.LoadState

interface UserRepository {
    fun getUsers(request: UsersGetRequest? = null): Flow<LoadState<UserResponse>>

    fun getUser(id: String?): Flow<LoadState<UserData>>

    fun getUserAuth(): Flow<LoadState<String?>>

    fun putUser(userData: UserData): Flow<LoadState<UserData?>>

    fun postUser(userData: UserData): Flow<LoadState<UserData?>>

    fun getNameUser(): Flow<LoadState<String>>

    fun setNameUser(name: String): Flow<LoadState<Boolean>>

    fun getPhoneUser(): Flow<LoadState<String>>

    fun setPhoneUser(phone: String): Flow<LoadState<Boolean>>

    fun deleteUser(): Flow<LoadState<Boolean>>

    fun changeSubscriptionEventStatus(eventID: String): Flow<LoadState<UserSubscribeStatusResponse>>

    fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>>

    fun getSubscriptionCommunityStatus(idCommunity: String): Flow<LoadState<UserSubscribeStatusResponse>>

    fun getSubscriptionEventStatus(idEvent: String): Flow<LoadState<UserSubscribeStatusResponse>>
}