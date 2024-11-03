package ru.wb.repository.data.api.model

internal data class ContentItems(
    val id: String,
    val label: String = "",
    val usersList: List<User>? = null,
    val eventList: List<Event>? = null,
    val communityList: List<Community>? = null,
    val isStatic: Boolean = false,
)