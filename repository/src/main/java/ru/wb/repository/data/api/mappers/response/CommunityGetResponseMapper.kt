package ru.wb.repository.data.api.mappers.response

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.mappers.models.CommunityMapper
import ru.wb.repository.data.api.services.community.CommunityGetResponse

internal class CommunityGetResponseMapper(
    private val communityMapper: CommunityMapper,
) : Mapper<CommunityGetResponse, ru.wb.domain.repository.community.CommunityGetResponse> {
    override fun transformToDomain(
        data: CommunityGetResponse
    ): ru.wb.domain.repository.community.CommunityGetResponse {
        return ru.wb.domain.repository.community.CommunityGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { communityMapper.transformToDomain(it) },
        )
    }

    override fun transformToRepository(
        data: ru.wb.domain.repository.community.CommunityGetResponse
    ): CommunityGetResponse {
        return CommunityGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { communityMapper.transformToRepository(it) },
        )
    }
}