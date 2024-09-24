package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.ResultResponse
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityResponse
import kotlin.random.Random

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

    override fun subscribeOnCommunity(idUser: String, idCommunity: String): Flow<ResultResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> ResultResponse.SUCCESS
                else -> ResultResponse.ERROR
            }
        )
    }
}