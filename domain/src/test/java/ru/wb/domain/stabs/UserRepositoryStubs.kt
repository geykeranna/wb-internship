package ru.wb.domain.stabs

import ru.wb.domain.model.UserData
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.repisotory.model.UsersGetRequest

internal class UserRepositoryStubs: UserRepository {
    private val userData = UserData(
        id = "1",
        firstName = "Name",
        lastName = null,
        icon = null,
        story = false,
        status = false,
        phone = "0000000000",
        socialMedia = listOf()
    )

    override suspend fun getUsers(data: UsersGetRequest?): List<UserData> {
        data?.limit?.let {
            return List(it) { userData }
        }
        return listOf(userData)
    }

    override suspend fun getUser(id: String): UserData = userData

    override suspend fun putUser(userData: UserData): Boolean = true

    override suspend fun postUser(userData: UserData): Boolean = true

    override suspend fun handleGoingEvent(eventID: String): Boolean = true
}