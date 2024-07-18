package ru.testtask.testapplication.repository.data.repisotory

import ru.testtask.testapplication.repository.data.model.CommunityData
import ru.testtask.testapplication.domain.repisotory.CommunityRepository

interface CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(): List<CommunityData> = List(10) { CommunityData.shimmerData }

    override suspend fun getCommunity(id: String): CommunityData = CommunityData.shimmerData

    override suspend fun getCommunitiesBySearch(query: String): List<CommunityData> {
        return List(3) { CommunityData.shimmerData }
    }
}