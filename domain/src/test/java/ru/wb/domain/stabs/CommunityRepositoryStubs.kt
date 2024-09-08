package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.model.CommunitiesGetRequest

internal class CommunityRepositoryStubs: CommunityRepository {
    private val communityData: CommunityData = CommunityData(
        id = "1",
        label = "Community",
        icon = null,
        description = "Community Test",
        eventList = listOf(),
        tags = listOf(),
        subscribers = listOf(),
        isSubscribed = false,
        isVerified = false,
    )

    override fun getCommunities(
        data: CommunitiesGetRequest?
    ): Flow<List<CommunityData>> {
        data?.limit?.let {
            return flowOf(List (it) { communityData })
        }
        return flowOf(listOf(communityData))

    }

    override fun getCommunity(
        id: String
    ): Flow<CommunityData> = flowOf(communityData)

    override fun subscribeOnCommunity(idUser: String, idCommunity: String): Flow<Boolean> {
        return flowOf(true)
    }
}