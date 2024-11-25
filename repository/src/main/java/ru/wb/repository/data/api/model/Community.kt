package ru.wb.repository.data.api.model

internal data class Community (
    val id: String,
    val label: String,
    val subscribers: List<UserItem>,
    val icon: String?,
    val description: String,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
)