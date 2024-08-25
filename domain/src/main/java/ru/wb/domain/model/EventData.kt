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
            usersList = mutableListOf(),
            manager = UserData(
                firstName = "Павел",
                lastName = "Хориков",
                description = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                icon = null,
                id = "user",
                socialMedia = listOf(),
                phone = ""
            ),
            sponsor = CommunityData(
                label = "The IT-Crowd",
                description = "Сообщество профессионалов в сфере IT. Объединяем специалистов разных направлений для обмена опытом, знаниями и идеями.",
                icon = null,
                countPeople = 0,
                id = "owner",
                eventList = listOf(),
                isVerified = true
            ),
            recommendation = listOf()
        )
    }
}
