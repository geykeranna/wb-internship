package ru.wb.repository.data.api.services.common

import ru.wb.repository.data.api.model.Content

internal data class ContentGetResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<Content>,
)