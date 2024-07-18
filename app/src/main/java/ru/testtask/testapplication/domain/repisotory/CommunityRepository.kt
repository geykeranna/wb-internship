package ru.testtask.testapplication.domain.repisotory

import ru.testtask.testapplication.repository.data.model.CommunityData

interface CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData

    suspend fun getCommunitiesBySearch(query: String): List<CommunityData>

    suspend fun getCommunities(query: String? = null): List<CommunityData>
}