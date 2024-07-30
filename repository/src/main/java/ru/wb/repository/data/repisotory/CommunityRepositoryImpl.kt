package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.repository.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.model.CommunitiesGetRequest

internal class CommunityRepositoryImpl: CommunityRepository {
    override fun getCommunities(
        data: CommunitiesGetRequest?
    ): Flow<List<CommunityData>> {
        return flowOf(List(10) {CommunityData.defaultObject})
    }

    override fun getCommunity(
        id: String
    ): Flow<CommunityData> {
        return flowOf(CommunityData.defaultObject)
    }
}