package ru.wb.repository.data.api.mappers.request

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.services.user.UserGetRequest

internal class UsersGetRequestMapper: Mapper<UserGetRequest, ru.wb.domain.repository.user.UsersGetRequest> {
    override fun transformToDomain(data: UserGetRequest): ru.wb.domain.repository.user.UsersGetRequest {
        return ru.wb.domain.repository.user.UsersGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            communityId = data.communityId,
            eventId = data.eventId,
        )
    }

    override fun transformToRepository(data: ru.wb.domain.repository.user.UsersGetRequest): UserGetRequest {
        return UserGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            communityId = data.communityId,
            eventId = data.eventId,
        )
    }
}