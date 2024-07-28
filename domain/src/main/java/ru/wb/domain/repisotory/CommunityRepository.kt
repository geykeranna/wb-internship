package ru.wb.domain.repisotory

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

interface CommunityRepository {
    suspend fun getCommunity(id: String): Flow<CommunityData>

    suspend fun getCommunities(data: CommunitiesGetRequest? = null): Flow<List<CommunityData>>
}