package ru.wb.domain.model

data class EventsByGroup(
    val listOfEvents: List<EventData>,
    val group: String,
) {
    companion object {
        val defaultObject = EventsByGroup(listOfEvents = listOf(), group = "")
    }
}
