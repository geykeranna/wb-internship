package ru.wb.domain.model

data class EventData(
    val id: String,
    val name: String,
    val date: String,
    val location: Location,
    val tagList: List<String>,
    val icon: String?,
    val active: Boolean,
    val description: String,
    val vacantSeat: Int,
    val usersList: List<UserData> = listOf(),
    val manager: UserData,
    val sponsor: CommunityData,
    val recommendation: List<EventData> = listOf()
){
    companion object{
        val defaultObject = EventData(
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
            vacantSeat = 10
        )
    }
}
