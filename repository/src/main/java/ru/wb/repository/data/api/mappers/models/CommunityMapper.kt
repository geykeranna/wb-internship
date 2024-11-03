package ru.wb.repository.data.api.mappers.models

import ru.wb.domain.model.CommunityData
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Community

internal class CommunityMapper(
//    private val eventMapper: EventMapper,
    private val userMapper: UserMapper,
) : Mapper<Community, CommunityData> {
    override fun transformToDomain(data: Community): CommunityData {
        return CommunityData(
            id = data.id,
            label = data.label,
            description = data.description,
            icon = data.icon,
            isVerified = data.isVerified,
            isSubscribed = data.isSubscribed,
            lastEvent = listOf(),
            eventList = listOf(),
            tags = data.tags,
            subscribers = data.subscribers.map { userMapper.transformToDomain(it) }
        )
    }

    override fun transformToRepository(data: CommunityData): Community {
        return Community(
            id = data.id,
            label = data.label,
            description = data.description,
            icon = data.icon,
            isVerified = data.isVerified,
            isSubscribed = data.isSubscribed,
            lastEvent = listOf(),
            eventList = listOf(),
            tags = data.tags,
            subscribers = data.subscribers.map { userMapper.transformToRepository(it) }
        )
    }
}