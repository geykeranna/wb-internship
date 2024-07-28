package ru.wb.domain.repisotory.model

data class EventGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val userId: String? = null,
    val state: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
)