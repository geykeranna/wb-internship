package ru.wb.repository.data.sharedpreferences

internal interface Storage {
    fun saveValue(value: String): Boolean

    fun getValue(): String
}