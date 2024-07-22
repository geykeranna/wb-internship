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
            id = "0",
            label = "Developer meeting",
            icon = null,
            countPeople = 10000,
            description = "Описание",
            eventList = List(5){ EventData.defaultObject }
        )
    }
}