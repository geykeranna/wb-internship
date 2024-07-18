package ru.testtask.testapplication.repository.data.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

data class CommunityData (
    val id: String,
    val label: String,
    val countPeople: Int,
    val icon: String?,
    val description: String,
    val eventList: List<EventData>
){
    companion object{
        val shimmerData = CommunityData(
            id = "0",
            label = "Developer meeting",
            icon = null,
            countPeople = 10000,
            description = LoremIpsum(120).values.first(),
            eventList = listOf(
                EventData.shimmerData1,
                EventData.shimmerData1,
                EventData.shimmerData1,
                EventData.shimmerData1,
                EventData.shimmerData2,
                EventData.shimmerData2,
                EventData.shimmerData2,
                EventData.shimmerData2,
                EventData.shimmerData2,
            )
        )
    }

    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            label, description,
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}