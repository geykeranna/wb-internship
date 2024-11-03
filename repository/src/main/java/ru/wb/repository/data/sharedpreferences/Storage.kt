package ru.wb.repository.data.sharedpreferences

internal interface Storage {
    fun saveValue(token: String): Boolean

    fun getValue(): String
}