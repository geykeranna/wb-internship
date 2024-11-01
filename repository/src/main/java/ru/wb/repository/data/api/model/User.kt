package ru.wb.repository.data.api.model

internal data class User(
    val id: String,
    val icon: String? = null,
    val name: String,
    val story: Boolean = false,
    val status: Boolean = false,
    val phone: String,
    val location: String = "",
    val role: List<String>? = null,
    val socialMedia: List<SocialMedia> = listOf(),
    val tags: List<String> = listOf(),
    val description: String = "",
    val isShowCommunity: Boolean = true,
    val isShowEvent: Boolean = true,
    val enableNotification: Boolean = true,
)