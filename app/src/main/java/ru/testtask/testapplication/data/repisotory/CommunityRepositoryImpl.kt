package ru.testtask.testapplication.data.repisotory

import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.repisotory.CommunityRepository

interface CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(): List<CommunityData> = List(10) { CommunityData.shimmerData }

    override suspend fun getCommunity(id: String): CommunityData = CommunityData.shimmerData
}