package ru.wb.domain.stabs

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.repisotory.model.UsersGetRequest

internal class UserRepositoryStubs: UserRepository {
    override suspend fun getUsers(data: UsersGetRequest?): List<UserData> = List(10) { UserData.defaultObject }

    override suspend fun getUser(id: String): UserData = UserData.defaultObject

    override suspend fun putUser(userData: UserData): Boolean = false

    override suspend fun postUser(userData: UserData): Boolean = false

    override suspend fun handleGoingEvent(eventID: String): Boolean {
        return true
    }
}