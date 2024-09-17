package ru.wb.domain.repository.common

import ru.wb.domain.model.Content

data class ContentResponse(
    val limit: Int?,
    val offset: Int?,
    val data: Content,
)
