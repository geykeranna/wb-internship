package ru.wb.repository.data.api.services.community

import ru.wb.repository.data.api.model.Community

internal data class CommunityGetResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<Community>,
)