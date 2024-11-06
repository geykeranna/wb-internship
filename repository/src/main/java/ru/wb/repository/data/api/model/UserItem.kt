package ru.wb.repository.data.api.model

internal data class UserItem(
    val id: String,
    val icon: String? = null,
    val name: String,
    val story: Boolean = false,
    val status: Boolean = false,
    val role: List<String>? = null,
    val description: String = "",
)