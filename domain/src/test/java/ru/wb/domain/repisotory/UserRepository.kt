package ru.wb.domain.repisotory

import ru.wb.domain.model.UserData

data class UsersGetRequest(
    val limit: String? = null,
    val offset: String? = null,
    val query: String? = null,
    val communityId: String? = null,
    val eventId: String? = null,
)


interface UserRepository {
    suspend fun getUsers(data: UsersGetRequest): List<UserData>

    suspend fun getUser(id: String): UserData

    suspend fun putUser(userData: UserData): Boolean

    suspend fun postUser(userData: UserData): Boolean
}