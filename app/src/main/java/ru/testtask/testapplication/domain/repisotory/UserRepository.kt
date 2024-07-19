package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.repository.data.model.UserData

interface UserRepository {
    suspend fun getUsers(): List<UserData>

    suspend fun getUser(id: String): UserData

    suspend fun setUser(userData: UserData): Boolean
}