package ru.testtask.testapplication.data.repisotory

import ru.testtask.testapplication.data.model.UserData
import ru.testtask.testapplication.domain.repisotory.UserRepository

interface UserRepositoryImpl: UserRepository {
    override suspend fun getUsers(): List<UserData> = List(10) { UserData.shimmerData }

    override suspend fun getUser(): UserData = UserData.shimmerData
}