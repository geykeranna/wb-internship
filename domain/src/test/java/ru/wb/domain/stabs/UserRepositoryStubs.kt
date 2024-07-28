package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
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

    override suspend fun getUsers(data: UsersGetRequest?): Flow<List<UserData>> {
        data?.limit?.let {
            return flowOf(List(it) { userData })
        }
        return flowOf(listOf(userData))
    }

    override suspend fun getUser(id: String) = flowOf(userData)

    override suspend fun putUser(userData: UserData) = flowOf(true)

    override suspend fun postUser(userData: UserData) = flowOf(true)

    override suspend fun handleGoingEvent(eventID: String) = flowOf(true)
}