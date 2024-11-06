package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.EventItemData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.EventItem

internal class EventItemMapper(
    private val locationMapper: LocationMapper
): Mapper<EventItem, EventItemData>{
    override fun transformToDomain(data: EventItem): EventItemData {
        return EventItemData(
            id = data.id,
            name = data.name,
            date = data.date,
            location = locationMapper.transformToDomain(data.location),
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
        )
    }

    override fun transformToRepository(data: EventItemData): EventItem {
        return EventItem(
            id = data.id,
            name = data.name,
            date = data.date,
            location = locationMapper.transformToRepository(data.location),
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
        )
    }
}