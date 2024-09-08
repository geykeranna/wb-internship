package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.UserRepository
import ru.wb.domain.repository.model.UsersGetRequest

internal class UserRepositoryImpl: UserRepository {
    override fun getUsers(data: UsersGetRequest?): Flow<List<UserData>> {
        return flowOf(List(10) { UserData.defaultObject })
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

    override fun changeSubscriptionEventStatus(eventID: String): Flow<Boolean> {
        return flowOf(true)
    }

    override fun changeSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean> {
        return flowOf(true)
    }

    override fun getSubscriptionCommunityStatus(idCommunity: String): Flow<Boolean> {
        return flowOf(true)
    }

    override fun getSubscriptionEventStatus(idEvent: String): Flow<Boolean> {
        return flowOf(false)
    }
}