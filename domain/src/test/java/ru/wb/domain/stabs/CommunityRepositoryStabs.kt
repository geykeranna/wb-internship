package ru.wb.domain.stabs

import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class CommunityRepositoryStabs: CommunityRepository {
    override suspend fun getCommunities(
        data: CommunitiesGetRequest?
    ): List<CommunityData> = List(10) {CommunityData.defaultObject}

    override suspend fun getCommunity(
        id: String
    ): CommunityData = CommunityData.defaultObject
}