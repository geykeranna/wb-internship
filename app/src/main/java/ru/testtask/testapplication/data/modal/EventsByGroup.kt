package ru.testtask.testapplication.data.modal

data class EventsByGroup(
    val listOfEvents: List<EventData>,
    val group: String,
) {
    companion object{
        val shimmerData = EventsByGroup(
            group = "Group",
            listOfEvents = listOf(
                EventData.shimmerData1,
                EventData.shimmerData2,
                EventData.shimmerData1,
                EventData.shimmerData2,
                EventData.shimmerData1,
                EventData.shimmerData1,
                EventData.shimmerData2,
                EventData.shimmerData1,
                EventData.shimmerData1,
            )
        )

        val shimmerDataList1 = listOf(
            EventsByGroup(
                group = "Все встречи",
                listOfEvents = listOf(
                    EventData.shimmerData1,
                    EventData.shimmerData2,
                    EventData.shimmerData1,
                    EventData.shimmerData2,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData2,
                )
            ),
            EventsByGroup(
                group = "Активные",
                listOfEvents = listOf(
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                )
            )
        )
        val shimmerDataList2 = listOf(
            EventsByGroup(
                group = "Запланировано",
                listOfEvents = listOf(
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                    EventData.shimmerData1,
                )
            ),
            EventsByGroup(
                group = "Уже прошли",
                listOfEvents = listOf(
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                    EventData.shimmerData2,
                )
            )
        )
    }
}
