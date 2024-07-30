package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.model.CommunitiesGetRequest

interface CommunityRepository {
    fun getCommunity(id: String): Flow<CommunityData>

    fun getCommunities(data: CommunitiesGetRequest? = null): Flow<List<CommunityData>>
}