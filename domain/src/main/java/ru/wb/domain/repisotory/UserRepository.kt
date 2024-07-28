package ru.wb.domain.repisotory

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.model.UsersGetRequest

interface UserRepository {
    suspend fun getUsers(data: UsersGetRequest? = null): Flow<List<UserData>>

    suspend fun getUser(id: String): Flow<UserData>

    suspend fun putUser(userData: UserData): Flow<Boolean>

    suspend fun postUser(userData: UserData): Flow<Boolean>

    suspend fun handleGoingEvent(eventID: String): Flow<Boolean>
}