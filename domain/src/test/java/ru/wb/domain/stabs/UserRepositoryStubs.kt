package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.UserData
import ru.wb.domain.repository.UserRepository
import ru.wb.domain.repository.model.UsersGetRequest

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

    override fun getUsers(data: UsersGetRequest?): Flow<List<UserData>> {
        data?.limit?.let {
            return flowOf(List(it) { userData })
        }
        return flowOf(listOf(userData))
    }

    override fun getUser(id: String) = flowOf(userData)

    override fun putUser(userData: UserData) = flowOf(true)

    override fun postUser(userData: UserData) = flowOf(true)

    override fun handleGoingEvent(eventID: String) = flowOf(true)

    override fun changeSubscriptionStatus(idCommunity: String): Flow<Boolean> = flowOf(true)

    override fun getSubscriptionStatus(idCommunity: String): Flow<Boolean> = flowOf(true)
}