package ru.wb.domain.repository.community

import ru.wb.domain.model.CommunityData

data class CommunityResponse(
    val limit: Int?,
    val offset: Int?,
    val data: List<CommunityData>,
)
