package ru.wb.repository.data.api.services.common

internal data class ContentGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val filter: List<String>? = null,
    val search: String? = null,
)