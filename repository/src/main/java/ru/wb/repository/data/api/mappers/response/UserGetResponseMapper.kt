package ru.wb.repository.data.api.mappers.response

import ru.wb.domain.repository.user.UserResponse
import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.mappers.models.UserMapper
import ru.wb.repository.data.api.services.user.UserGetResponse

internal class UserGetResponseMapper(
    private val userMapper: UserMapper,
) : Mapper<UserGetResponse, UserResponse> {
    override fun transformToDomain(data: UserGetResponse): UserResponse {
        return UserResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { userMapper.transformToDomain(it) },
        )
    }

    override fun transformToRepository(data: UserResponse): UserGetResponse {
        return UserGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { userMapper.transformToRepository(it) },
        )
    }
}