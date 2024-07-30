package ru.wb.domain.repository.model

data class CommunitiesGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
)
