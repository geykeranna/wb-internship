package ru.wb.repository.data.api.model

internal data class Content(
    val id: String,
    val label: String = "",
    val usersList: List<UserItem>? = null,
    val eventList: List<EventItem>? = null,
    val communityList: List<CommunityItem>? = null,
)