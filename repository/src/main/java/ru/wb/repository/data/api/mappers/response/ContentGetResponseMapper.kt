package ru.wb.repository.data.api.mappers.response

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.mappers.models.ContentMapper
import ru.wb.repository.data.api.services.common.ContentGetResponse

internal class ContentGetResponseMapper(
    private val contentMapper: ContentMapper,
) : Mapper<ContentGetResponse, ru.wb.domain.repository.common.ContentGetResponse> {
    override fun transformToDomain(
        data: ContentGetResponse
    ): ru.wb.domain.repository.common.ContentGetResponse {
        return ru.wb.domain.repository.common.ContentGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { contentMapper.transformToDomain(it) }
        )
    }

    override fun transformToRepository(
        data: ru.wb.domain.repository.common.ContentGetResponse
    ): ContentGetResponse {
        return ContentGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { contentMapper.transformToRepository(it) },
        )
    }
}