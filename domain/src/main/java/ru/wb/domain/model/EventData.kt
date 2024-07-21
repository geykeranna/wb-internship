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
    val usersList: MutableList<UserData> = mutableListOf()
){
    companion object{
        val defaultObject = EventData(
            id = "0",
            name = "Developer meeting",
            location = Location("Москва", "ул. Громова, 4"),
            date = "19.09.2024",
            tagList = listOf("Python", "Junior", "Moscow"),
            icon = null,
            active = true,
            description = "",
            usersList = mutableListOf(UserData.defaultObject)
        )
    }
}
