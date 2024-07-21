package ru.wb.domain.model

data class EventsByGroup(
    val listOfEvents: List<EventData>,
    val group: String,
) {
    companion object {
        val defaultObject = listOf(
            EventsByGroup(
                group = "Все встречи",
                listOfEvents = List(10) { EventData.defaultObject }
            ),
            EventsByGroup(
                group = "Активные",
                listOfEvents = List(10) { EventData.defaultObject }
            )
        )
    }
}
