package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.repisotory.model.UsersGetRequest

internal class UserRepositoryImpl: UserRepository {
    override suspend fun getUsers(data: UsersGetRequest?): Flow<List<UserData>> {
        return flowOf(List(10) { UserData.defaultObject })
    }

    override suspend fun getUser(id: String): Flow<UserData> {
        return flowOf(UserData.defaultObject)
    }

    override suspend fun putUser(userData: UserData): Flow<Boolean>{
        return flowOf(false)
    }

    override suspend fun postUser(userData: UserData): Flow<Boolean> {
        return flowOf(false)
    }

    override suspend fun handleGoingEvent(eventID: String): Flow<Boolean> {
        return flowOf(true)
    }
}