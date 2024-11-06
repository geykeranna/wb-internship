package ru.wb.domain.model

data class Content(
    val id: String,
    val label: String = "",
    val usersList: List<UserItemsData>? = null,
    val eventList: List<EventItemData>? = null,
    val communityList: List<CommunityItemData>? = null,
){
    companion object{
        val defaultObjects = listOf(
            Content(
                id = "1",
                label = "",
                eventList = List (3) { EventItemData.defaultObject },
            ),
            Content(
                id = "2",
                label = "Ближайшие встречи",
                eventList = List (3) { EventItemData.defaultObject },
            ),
            Content(
                id = "3",
                label = "Сообщества для тестировщиков",
                communityList = List(3) { CommunityItemData.defaultObject },
            ),
            Content(
                id = "4",
                label = "",
                eventList = List (3) { EventItemData.defaultObject },
            ),
        )
    }
}
