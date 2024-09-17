package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityResponse

internal class CommunityRepositoryImpl: CommunityRepository {
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
    ): Flow<CommunityData> {
        return flowOf(CommunityData.defaultObject)
    }

    override fun subscribeOnCommunity(idUser: String, idCommunity: String): Flow<Boolean> {
        return flowOf(true)
    }
}