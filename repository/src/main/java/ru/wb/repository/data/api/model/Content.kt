package ru.wb.repository.data.api.model

internal data class Content(
    val id: String?,
    val time: String? = "",
    val description: String = "",
    val items: List<ContentItems> = listOf(),
)