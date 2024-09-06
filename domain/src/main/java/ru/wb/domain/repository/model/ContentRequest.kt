package ru.wb.domain.repository.model

data class ContentRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val filter: List<String>? = null,
    val search: String? = null,
)
