package ru.testtask.testapplication.data.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

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
        val shimmerData1 = EventData(
            id = "0",
            name = "Developer meeting",
            location = Location("Москва", "ул. Громова, 4"),
            date = "19.09.2024",
            tagList = listOf("Python", "Junior", "Moscow"),
            icon = null,
            active = true,
            description = LoremIpsum(120).values.first(),
            usersList = mutableListOf(
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
            )
        )
        val shimmerData2 = EventData(
            id = "0",
            name = "Developer meeting",
            location = Location("Москва", "ул. Громова, 4"),
            date = "19.09.2024",
            tagList = listOf("Python", "Junior", "Moscow"),
            icon = null,
            active = false,
            description = LoremIpsum(120).values.first(),
            usersList = mutableListOf(
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
                UserData.shimmerData,
            )
        )
    }
}
