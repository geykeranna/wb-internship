package ru.wb.domain.repisotory.model

data class CommunitiesGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
)
