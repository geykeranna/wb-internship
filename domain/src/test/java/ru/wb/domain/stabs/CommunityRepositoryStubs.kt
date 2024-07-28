package ru.wb.domain.stabs

import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class CommunityRepositoryStubs: CommunityRepository {
    private val communityData: CommunityData = CommunityData(
        id = "1",
        label = "Community",
        icon = null,
        countPeople = 20,
        description = "Community Test",
        eventList = listOf()
    )

    override suspend fun getCommunities(
        data: CommunitiesGetRequest?
    ): List<CommunityData> {
        data?.limit?.let {
            return List (it) { communityData }
        }
        return listOf(communityData)

    }

    override suspend fun getCommunity(
        id: String
    ): CommunityData = communityData
}