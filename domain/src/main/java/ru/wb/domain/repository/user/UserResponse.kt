package ru.wb.domain.repository.user

import ru.wb.domain.model.UserData

data class UserResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<UserData>,
)

enum class UserSubscribeStatusResponse{
    SUBSCRIBED,
    NOT_SUBSCRIBED,
}