package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.presentation.data.model.UserData

interface UserRepository {
    suspend fun getUsers(): List<UserData>

    suspend fun getUser(id: String): UserData
}