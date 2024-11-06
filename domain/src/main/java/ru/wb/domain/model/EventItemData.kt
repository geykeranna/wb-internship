package ru.wb.domain.model

data class EventItemData(
    val id: String,
    val name: String,
    val date: String,
    val location: Location,
    val tagList: List<String>,
    val icon: String?,
    val active: Boolean,
    val description: String,
    val vacantSeat: Int,
){
    companion object{
        val defaultObject = EventItemData(
            id = "1",
            name = "QA Talks — Global tech forum",
            location = Location.defaultObject,
            date = "10 августа",
            tagList = listOf("Moscow", "Android", "Moscow", "Android", "Moscow", "Android"),
            icon = null,
            active = true,
            description = "Description",
            vacantSeat = 10
        )
    }
}
