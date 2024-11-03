package ru.wb.domain.repository.community

data class CommunitiesGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val idEvent: String? = null,
    val idUser: String? = null,
)
