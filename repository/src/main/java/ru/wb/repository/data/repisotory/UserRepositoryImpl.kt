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

    override fun getUser(id: String): Flow<UserData> {
        return flowOf(UserData.defaultObject)
    }

    override fun putUser(userData: UserData): Flow<Boolean>{
        return flowOf(false)
    }

    override fun postUser(userData: UserData): Flow<Boolean> {
        return flowOf(false)
    }

    override fun handleGoingEvent(eventID: String): Flow<Boolean> {
        return flowOf(true)
    }
}