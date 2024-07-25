package ru.wb.repository.data.repisotory

import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(
        data: CommunitiesGetRequest?
    ): List<CommunityData> = List(10) {CommunityData.defaultObject}

    override suspend fun getCommunity(
        id: String
    ): CommunityData = CommunityData.defaultObject
}