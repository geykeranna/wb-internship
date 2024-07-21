package ru.wb.domain.repisotory

import ru.wb.domain.model.UserData

interface UserRepository {
    suspend fun getUsers(): List<UserData>

    suspend fun getUser(id: String?): UserData

    suspend fun setUser(userData: UserData): Boolean
}