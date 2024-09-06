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
    val lastEvent: List<EventData> = listOf()
){
    companion object{
        val defaultObject = CommunityData(
            id = "1",
            label = "The IT-Crowd",
            icon = null,
            subscribers = List (10) { UserData.defaultObject },
            description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
            eventList = List (10) { EventData(
                id = "1",
                name = "QA Talks — Global tech forum",
                location = Location.defaultObject,
                date = "10 августа",
                tagList = listOf("Moscow", "Android"),
                icon = null,
                active = true,
                description = "Description",
                usersList = List (10) { UserData.defaultObject },
                manager = UserData.defaultObject,
                sponsor = CommunityData(
                    id = "1",
                    label = "The IT-Crowd",
                    icon = null,
                    subscribers = List (10) { UserData.defaultObject },
                    description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                    eventList = listOf(),
                    isVerified = false,
                    isSubscribed = false,
                    tags = listOf("Разработка")
                ),
                recommendation = listOf(),
                vacantSeat = 10,
            ) },
            isVerified = false,
            isSubscribed = false,
            tags = listOf("Разработка", "Support", "Production", "Presentation", "Mobile"),
            lastEvent = List (10) {
                EventData(
                    id = "1",
                    name = "QA Talks — Global tech forum",
                    location = Location.defaultObject,
                    date = "10 августа",
                    tagList = listOf("Moscow", "Android"),
                    icon = null,
                    active = true,
                    description = "Description",
                    usersList = List (10) { UserData.defaultObject },
                    manager = UserData.defaultObject,
                    sponsor = CommunityData(
                        id = "1",
                        label = "The IT-Crowd",
                        icon = null,
                        subscribers = List (10) { UserData.defaultObject },
                        description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                        eventList = listOf(),
                        isVerified = false,
                        isSubscribed = false,
                        tags = listOf("Разработка")
                    ),
                    recommendation = listOf(),
                    vacantSeat = 10,
                )
            }
        )
    }
}