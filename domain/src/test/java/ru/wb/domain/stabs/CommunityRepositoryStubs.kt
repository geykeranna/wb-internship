package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityGetResponse

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
        request: CommunitiesGetRequest?
    ): Flow<LoadState<CommunityGetResponse>> {
        val communityResponse = CommunityGetResponse(
            limit = 10,
            offset = 0,
            data = List(10) {communityData}
        )
        return flowOf(LoadState.Success(communityResponse))
    }

    override fun getCommunity(
        id: String
    ): Flow<LoadState<CommunityData>> {
        return flowOf(LoadState.Success(communityData))
    }
}