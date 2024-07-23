package ru.wb.domain.repisotory

import ru.wb.domain.model.CommunityData

interface CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData

    suspend fun getCommunities(query: String? = null): List<CommunityData>
}