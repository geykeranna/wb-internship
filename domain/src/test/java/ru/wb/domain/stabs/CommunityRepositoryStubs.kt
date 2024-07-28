package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
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
    ): Flow<List<CommunityData>> {
        data?.limit?.let {
            return flowOf(List (it) { communityData })
        }
        return flowOf(listOf(communityData))

    }

    override suspend fun getCommunity(
        id: String
    ): Flow<CommunityData> = flowOf(communityData)
}