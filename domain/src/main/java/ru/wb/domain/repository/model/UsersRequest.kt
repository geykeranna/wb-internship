package ru.wb.domain.repository.model

data class UsersGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val communityId: String? = null,
    val eventId: String? = null,
)