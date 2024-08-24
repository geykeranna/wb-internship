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
            name = "QA Talks — Global tech forum",
            location = Location.defaultObject,
            date = "10 августа",
            tagList = listOf("Moscow", "Android"),
            icon = null,
            active = true,
            description = "Description",
            usersList = mutableListOf()
        )
    }
}
