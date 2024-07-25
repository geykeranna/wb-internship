package ru.wb.domain.repisotory

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.model.UsersGetRequest

interface UserRepository {
    suspend fun getUsers(data: UsersGetRequest? = null): List<UserData>

    suspend fun getUser(id: String): UserData

    suspend fun putUser(userData: UserData): Boolean

    suspend fun postUser(userData: UserData): Boolean
}