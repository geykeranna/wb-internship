package ru.wb.domain.model

data class Content(
    val id: String?,
    val time: String? = "",
    val description: String = "",
    val items: List<ContentItems> = listOf(),
){
    companion object{
        val defaultObject = Content(
            id = "1",
            items = listOf(
                ContentItems(
                    id = "1",
                    label = "",
                    eventList = List (10) {EventData.defaultObject},
                    isStatic = true,
                ),
                ContentItems(
                    id = "2",
                    label = "Ближайшие встречи",
                    eventList = List (10) {EventData.defaultObject},
                    isStatic = true,
                ),
                ContentItems(
                    id = "3",
                    label = "Сообщества для тестировщиков",
                    communityList = List (10) {CommunityData.defaultObject},
                    isStatic = true,
                ),
                ContentItems(
                    id = "4",
                    label = "",
                    eventList = List (10) {EventData.defaultObject},
                ),

            )
        )
    }
}
