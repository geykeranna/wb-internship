package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(
        data: CommunitiesGetRequest?
    ): Flow<List<CommunityData>> {
        return flowOf(List(10) {CommunityData.defaultObject})
    }

    override suspend fun getCommunity(
        id: String
    ): Flow<CommunityData> {
        return flowOf(CommunityData.defaultObject)
    }
}