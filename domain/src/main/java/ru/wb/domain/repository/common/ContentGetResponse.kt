package ru.wb.domain.repository.common

import ru.wb.domain.model.Content

data class ContentGetResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<Content>,
)
