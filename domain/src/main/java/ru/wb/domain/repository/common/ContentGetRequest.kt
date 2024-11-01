package ru.wb.domain.repository.common

data class ContentGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val filter: List<String>? = null,
    val search: String? = null,
)
