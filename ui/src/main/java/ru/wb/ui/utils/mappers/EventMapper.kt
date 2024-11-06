package ru.wb.ui.utils.mappers

import ru.wb.domain.model.EventData
import ru.wb.domain.model.EventItemData

internal class EventToEventItemMapper: Mapper<EventData, EventItemData> {
    override fun transformTo(data: EventData): EventItemData {
        return EventItemData(
            id = data.id,
            name = data.name,
            date = data.date,
            location = data.location,
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
        )
    }

    override fun transformFrom(data: EventItemData): EventData {
        return EventData(
            id = data.id,
            name = data.name,
            date = data.date,
            location = data.location,
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
            usersList = listOf(),
            manager = null,
            sponsor = null,
            recommendation = null,
        )
    }
}
