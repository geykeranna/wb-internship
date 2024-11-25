package ru.wb.repository.data.api.model

internal data class Event(
    val id: String,
    val name: String,
    val date: String,
    val location: Location,
    val tagList: List<String>,
    val icon: String?,
    val active: Boolean,
    val description: String,
    val vacantSeat: Int,
    val usersList: List<UserItem> = listOf(),
    val manager: UserItem? = null,
    val sponsor: CommunityItem? = null,
    val recommendation: List<EventItem>? = null
)