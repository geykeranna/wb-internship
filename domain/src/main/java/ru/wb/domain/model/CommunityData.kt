package ru.wb.domain.model

data class CommunityData (
    val id: String,
    val label: String,
    val subscribers: List<UserData>,
    val icon: String?,
    val description: String,
    val eventList: List<EventData>,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
){
    companion object{
        val defaultObject = CommunityData(
            id = "1",
            label = "The IT-Crowd",
            icon = null,
            subscribers = List (10) { UserData.defaultObject },
            description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
            eventList = List (10) { EventData.defaultObject },
            isVerified = false,
            isSubscribed = false,
            tags = listOf("Разработка")
        )
    }
}