package ru.wb.repository.data.api.mappers.response

import ru.wb.domain.repository.user.UserSubscribeStatusResponse
import ru.wb.repository.data.api.mappers.Mapper

internal class UserStatusGetResponseMapper: Mapper<Boolean, UserSubscribeStatusResponse> {
    override fun transformToDomain(data: Boolean): UserSubscribeStatusResponse {
        return when(data) {
            true -> UserSubscribeStatusResponse.SUBSCRIBED
            else -> UserSubscribeStatusResponse.NOT_SUBSCRIBED
        }
    }

    override fun transformToRepository(data: UserSubscribeStatusResponse): Boolean {
        return when(data) {
            UserSubscribeStatusResponse.SUBSCRIBED -> true
            else -> false
        }
    }
}