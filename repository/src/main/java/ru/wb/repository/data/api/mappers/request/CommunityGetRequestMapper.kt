package ru.wb.repository.data.api.mappers.request

import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.services.community.CommunityGetRequest

internal class CommunityGetRequestMapper: Mapper<CommunityGetRequest, CommunitiesGetRequest> {
    override fun transformToDomain(data: CommunityGetRequest): CommunitiesGetRequest {
        return CommunitiesGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            idUser = data.idUser,
            idEvent = data.idEvent,
        )
    }

    override fun transformToRepository(data: CommunitiesGetRequest): CommunityGetRequest {
        return CommunityGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            idUser = data.idUser,
            idEvent = data.idEvent,
        )
    }
}