package ru.wb.domain.repisotory

import ru.wb.domain.model.CommunityData

data class CommunitiesGetRequest(
    val limit: String? = null,
    val offset: String? = null,
    val query: String? = null,
)

interface CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData

    suspend fun getCommunities(data: CommunitiesGetRequest): List<CommunityData>
}