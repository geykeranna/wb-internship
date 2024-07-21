package ru.wb.repository.data.repisotory

import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData

class CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(query: String?): List<CommunityData> = listOf()

    override suspend fun getCommunity(id: String): CommunityData = CommunityData.defaultObject

    override suspend fun getCommunitiesBySearch(query: String): List<CommunityData> {
        return listOf()
    }
}