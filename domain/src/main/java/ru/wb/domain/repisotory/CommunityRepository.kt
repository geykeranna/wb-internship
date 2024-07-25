package ru.wb.domain.repisotory

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

interface CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData

    suspend fun getCommunities(data: CommunitiesGetRequest? = null): List<CommunityData>
}