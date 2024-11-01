package ru.wb.repository.data.api.services.user

import ru.wb.repository.data.api.model.User

internal data class UserGetResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<User>,
)