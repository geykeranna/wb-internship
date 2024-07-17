package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.data.model.EventData

interface LoginRepository {

    suspend fun sendCode(phoneNumber: String)

    suspend fun getPhoneAuth(): String
}