package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Content

internal class ContentMapper(
    private val userItemsMapper: UserItemsMapper,
    private val communityItemMapper: CommunityItemMapper,
    private val eventItemMapper: EventItemMapper,
) : Mapper<Content, ru.wb.domain.model.Content> {
    override fun transformToDomain(data: Content): ru.wb.domain.model.Content {
        return ru.wb.domain.model.Content(
            id = data.id,
            label = data.label,
            usersList = data.usersList?.map { userItemsMapper.transformToDomain(it) },
            eventList = data.eventList?.map { eventItemMapper.transformToDomain(it) },
            communityList = data.communityList?.map { communityItemMapper.transformToDomain(it) },
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.Content): Content {
        return Content(
            id = data.id,
            label = data.label,
            usersList = data.usersList?.map { userItemsMapper.transformToRepository(it) },
            eventList = data.eventList?.map { eventItemMapper.transformToRepository(it) },
            communityList = data.communityList?.map { communityItemMapper.transformToRepository(it) },
        )
    }
}