package ru.testtask.testapplication.repository.data.repisotory

import ru.testtask.testapplication.presentation.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.UserRepository

class UserRepositoryImpl: UserRepository {
    override suspend fun getUsers(): List<UserData> = List(10) { UserData.shimmerData }

    override suspend fun getUser(id: String): UserData = UserData.shimmerData
}