package ru.wb.domain.stabs

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityResponse

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
    ): Flow<CommunityResponse> {
        val communityResponse = CommunityResponse(
            limit = 10,
            offset = 0,
            data = List(10) {CommunityData.defaultObject}
        )
        return flowOf(communityResponse)
    }

    override fun getCommunity(
        id: String
    ): Flow<CommunityData> = flowOf(communityData)

    override fun subscribeOnCommunity(idUser: String, idCommunity: String): Flow<Boolean> {
        return flowOf(true)
    }
}