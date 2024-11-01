package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.EventData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Event

internal class EventMapper(
    private val userMapper: UserMapper,
    private val locationMapper: LocationMapper,
    private val communityMapper: CommunityMapper,
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
            usersList = data.usersList.map { userMapper.transformToDomain(it) },
            manager = userMapper.transformToDomain(data.manager),
            sponsor = communityMapper.transformToDomain(data.sponsor),
            recommendation = data.recommendation.map { transformToDomain(it) },
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
            usersList = data.usersList.map { userMapper.transformToRepository(it) },
            manager = userMapper.transformToRepository(data.manager),
            sponsor = communityMapper.transformToRepository(data.sponsor),
            recommendation = data.recommendation.map { transformToRepository(it) },
        )
    }
}