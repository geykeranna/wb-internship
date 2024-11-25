package ru.wb.domain.model

data class UserItemsData(
    val id: String,
    val icon: String? = null,
    val name: String,
    val description: String = "",
    val story: Boolean = false,
    val status: Boolean = false,
    val role: List<String>? = null,
)
