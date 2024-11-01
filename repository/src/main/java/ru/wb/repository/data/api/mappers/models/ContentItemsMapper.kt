package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.ContentItems

internal class ContentItemsMapper(
    private val userMapper: UserMapper,
    private val communityMapper: CommunityMapper,
    private val eventMapper: EventMapper,
) : Mapper<ContentItems, ru.wb.domain.model.ContentItems> {
    override fun transformToDomain(data: ContentItems): ru.wb.domain.model.ContentItems {
        return ru.wb.domain.model.ContentItems(
            id = data.id,
            label = data.label,
            usersList = data.usersList?.map { userMapper.transformToDomain(it) },
            eventList = data.eventList?.map { eventMapper.transformToDomain(it) },
            communityList = data.communityList?.map { communityMapper.transformToDomain(it) },
            isStatic = data.isStatic,
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.ContentItems): ContentItems {
        return ContentItems(
            id = data.id,
            label = data.label,
            usersList = data.usersList?.map { userMapper.transformToRepository(it) },
            eventList = data.eventList?.map { eventMapper.transformToRepository(it) },
            communityList = data.communityList?.map { communityMapper.transformToRepository(it) },
            isStatic = data.isStatic,
        )
    }
}