package ru.wb.repository.data.api.services.user

internal data class UserGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val communityId: String? = null,
    val eventId: String? = null,
)