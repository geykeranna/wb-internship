package ru.wb.domain.repository.event

import ru.wb.domain.model.EventItemData

data class EventGetResponse (
    val limit: Int?,
    val offset: Int?,
    val data: List<EventItemData>
)