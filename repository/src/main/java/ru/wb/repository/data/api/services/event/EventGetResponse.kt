package ru.wb.repository.data.api.services.event

import ru.wb.repository.data.api.model.EventItem

internal data class EventGetResponse (
    val limit: Int?,
    val offset: Int?,
    val data: List<EventItem>
)