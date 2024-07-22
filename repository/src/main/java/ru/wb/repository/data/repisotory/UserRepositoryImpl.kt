package ru.wb.repository.data.repisotory

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository

internal class UserRepositoryImpl: UserRepository {
    override suspend fun getUsers(): List<UserData> = List(10) { UserData.defaultObject }

    override suspend fun getUser(id: String?): UserData = UserData.defaultObject

    override suspend fun setUser(userData: UserData): Boolean = false
}