package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Content

internal class ContentMapper(
    private val contentItemsMapper: ContentItemsMapper,
) : Mapper<Content, ru.wb.domain.model.Content> {
    override fun transformToDomain(data: Content): ru.wb.domain.model.Content {
        return ru.wb.domain.model.Content(
            id = data.id,
            description = data.description,
            time = data.time,
            items = data.items.map { contentItemsMapper.transformToDomain(it) }
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.Content): Content {
        return Content(
            id = data.id,
            description = data.description,
            time = data.time,
            items = data.items.map { contentItemsMapper.transformToRepository(it) }
        )
    }
}