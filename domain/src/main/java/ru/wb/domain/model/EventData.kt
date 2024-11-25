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
    val usersList: List<UserItemsData> = listOf(),
    val manager: UserItemsData? = null,
    val sponsor: CommunityItemData? = null,
    val recommendation: List<EventItemData>? = null,
){
    companion object{
        val defaultObject = EventData(
            id = "1",
            name = "QA Talks — Global tech forum",
            location = Location.defaultObject,
            date = "10 августа",
            tagList = listOf("Moscow", "Android", "Moscow", "Android", "Moscow", "Android"),
            icon = null,
            active = true,
            description = "Description",
            usersList = listOf(),
            manager = null,
            sponsor = null,
            recommendation = listOf(),
            vacantSeat = 10
        )
    }
}
