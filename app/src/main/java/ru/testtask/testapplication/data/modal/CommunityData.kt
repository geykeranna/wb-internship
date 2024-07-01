package ru.testtask.testapplication.data.modal

data class CommunityData (
    val id: Int,
    val label: String,
    val countPeople: Int,
    val icon: String?
){
    companion object{
        val shimmerData = CommunityData(
            id = 0,
            label = "Developer meeting",
            icon = null,
            countPeople = 10000,
        )
    }
}