package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.EventData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Event

internal class EventMapper(
    private val userItemsMapper: UserItemsMapper,
    private val eventItemMapper: EventItemMapper,
    private val locationMapper: LocationMapper,
    private val communityItemMapper: CommunityItemMapper,
) : Mapper<Event, EventData> {
    override fun transformToDomain(data: Event): EventData {
        return EventData(
            id = data.id,
            name = data.name,
            date = data.date,
            location = locationMapper.transformToDomain(data.location),
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
            usersList = data.usersList.map { userItemsMapper.transformToDomain(it) },
            manager = data.manager?.let { userItemsMapper.transformToDomain(data.manager) },
            sponsor = data.sponsor?.let { communityItemMapper.transformToDomain(it) },
            recommendation = data.recommendation?.let { events ->
                events.map { eventItem -> eventItemMapper.transformToDomain(eventItem) }
            },
        )
    }

    override fun transformToRepository(data: EventData): Event {
        return Event(
            id = data.id,
            name = data.name,
            date = data.date,
            location = locationMapper.transformToRepository(data.location),
            tagList = data.tagList,
            icon = data.icon,
            active = data.active,
            description = data.description,
            vacantSeat = data.vacantSeat,
            usersList = data.usersList.map { userItemsMapper.transformToRepository(it) },
            manager = data.manager?.let { userItemsMapper.transformToRepository(it) },
            sponsor = data.sponsor?.let { communityItemMapper.transformToRepository(it) },
            recommendation = data.recommendation?.let { events ->
                events.map { eventItem -> eventItemMapper.transformToRepository(eventItem) }
            },
        )
    }
}