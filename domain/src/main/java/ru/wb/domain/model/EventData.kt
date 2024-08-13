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
            name = "Name",
            location = Location.defaultObject,
            date = "mmmm.mm.mm",
            tagList = listOf(),
            icon = null,
            active = true,
            description = "Description",
            usersList = mutableListOf()
        )
    }
}
