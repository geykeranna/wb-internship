package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.data.model.CommunityData

interface CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData

    suspend fun getCommunities(): List<CommunityData>
}