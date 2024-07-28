package ru.wb.domain.model

data class CommunityData (
    val id: String,
    val label: String,
    val countPeople: Int,
    val icon: String?,
    val description: String,
    val eventList: List<EventData>
){
    companion object{
        val defaultObject = CommunityData(
            id = "1",
            label = "",
            icon = null,
            countPeople = 0,
            description = "",
            eventList = listOf()
        )
    }
}