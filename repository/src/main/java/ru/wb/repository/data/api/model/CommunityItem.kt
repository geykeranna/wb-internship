package ru.wb.repository.data.api.model

internal data class CommunityItem(
    val id: String,
    val label: String,
    val icon: String?,
    val description: String,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
)
