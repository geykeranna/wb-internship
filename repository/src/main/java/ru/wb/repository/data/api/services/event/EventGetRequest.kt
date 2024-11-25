package ru.wb.repository.data.api.services.event

internal data class EventGetRequest(
    val limit: Int? = null,
    val offset: Int? = null,
    val query: String? = null,
    val idUser: String? = null,
    val idCommunity: String? = null,
    val state: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val type: String? = null,
)