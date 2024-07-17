package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.data.model.UserData

interface UserRepository {
    suspend fun getUsers(): List<UserData>

    suspend fun getUser(): UserData
}