package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

interface GetCommunityListUseCase {
    suspend fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
    ): List<CommunityData>
}