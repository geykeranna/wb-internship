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
    val usersList: List<UserData> = listOf()
){
    companion object{
        val defaultObject = EventData(
            id = "1",
            name = "",
            location = Location.defaultObject,
            date = "",
            tagList = listOf(),
            icon = null,
            active = true,
            description = "",
            usersList = mutableListOf()
        )
    }
}
