package ru.wb.domain.model

data class ContentItems(
    val id: String,
    val label: String = "",
    val usersList: List<UserData>? = null,
    val eventList: List<EventData>? = null,
    val communityList: List<CommunityData>? = null,
    val isStatic: Boolean = false,
)
