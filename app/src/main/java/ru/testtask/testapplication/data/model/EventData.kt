package ru.testtask.testapplication.data.model

data class EventData(
    val id: Int,
    val name: String,
    val date: String,
    val location: String,
    val tagList: List<String>,
    val icon: String?,
    val active: Boolean,
){
    companion object{
        val shimmerData1 = EventData(
            id = 0,
            name = "Developer meeting",
            location = "Москва",
            date = "19.09.2024",
            tagList = listOf("Python", "Junior", "Moscow"),
            icon = null,
            active = true,
        )
        val shimmerData2 = EventData(
            id = 0,
            name = "Developer meeting",
            location = "Москва",
            date = "19.09.2024",
            tagList = listOf("Python", "Junior", "Moscow"),
            icon = null,
            active = false,
        )
    }
}
