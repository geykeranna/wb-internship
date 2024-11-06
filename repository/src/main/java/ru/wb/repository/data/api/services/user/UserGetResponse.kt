package ru.wb.repository.data.api.services.user

import ru.wb.repository.data.api.model.UserItem

internal data class UserGetResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<UserItem>,
)