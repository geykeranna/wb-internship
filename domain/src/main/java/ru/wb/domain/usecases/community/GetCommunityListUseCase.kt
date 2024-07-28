package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

interface GetCommunityListUseCase {
    suspend fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
    ): Flow<List<CommunityData>>
}