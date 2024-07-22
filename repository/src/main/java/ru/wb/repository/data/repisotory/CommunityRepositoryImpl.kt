package ru.wb.repository.data.repisotory

import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.model.CommunityData

internal class CommunityRepositoryImpl: CommunityRepository {
    override suspend fun getCommunities(query: String?): List<CommunityData> = List(10) {CommunityData.defaultObject}

    override suspend fun getCommunity(id: String): CommunityData = CommunityData.defaultObject
}