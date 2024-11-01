package ru.wb.repository.data.api.services.community

internal data class CommunityGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val idEvent: String? = null,
    val idUser: String? = null,
)