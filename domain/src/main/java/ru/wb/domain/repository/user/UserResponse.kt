package ru.wb.domain.repository.user

import ru.wb.domain.model.UserItemsData

data class UserResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<UserItemsData>,
)

enum class UserSubscribeStatusResponse{
    SUBSCRIBED,
    NOT_SUBSCRIBED,
}