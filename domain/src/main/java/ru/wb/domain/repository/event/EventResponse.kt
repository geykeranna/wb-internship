package ru.wb.domain.repository.event

import ru.wb.domain.model.EventData

data class EventResponse (
    val limit: Int?,
    val offset: Int?,
    val data: List<EventData>
)