package ru.wb.domain.model

data class CommunityData (
    val id: String,
    val label: String,
    val subscribers: List<UserItemsData>,
    val icon: String?,
    val description: String,
    val eventList: List<EventItemData>,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
    val lastEvent: List<EventItemData> = listOf()
){
    companion object{
        val defaultObject = CommunityData(
            id = "1",
            label = "The IT-Crowd",
            icon = null,
            subscribers = listOf(),
            description = "Сообщество профессионалов в сфере IT.",
            eventList = List (10) { EventItemData.defaultObject },
            isVerified = false,
            isSubscribed = false,
            tags = listOf("Разработка"),
            lastEvent = List (10) { EventItemData.defaultObject }
        )
    }
}