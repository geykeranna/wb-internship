package ru.wb.domain.repisotory

import ru.wb.domain.model.CommunityData

data class CommunitiesGetRequest(
    val limit: String? = null,
    val offset: String? = null,
    val query: String? = null,
)

class TestCommunityRepository: CommunityRepository {
    suspend fun getCommunity(id: String): CommunityData = CommunityData(
        id = "1",
        label = "Community",
        icon = null,
        countPeople = 20,
        description = "Community Test",
        eventList = listOf()
    )

    suspend fun getCommunities(
        data: CommunitiesGetRequest
    ): List<CommunityData> = listOf(
        CommunityData(
            id = "1",
            label = "Community",
            icon = null,
            countPeople = 20,
            description = "Community Test",
            eventList = listOf()
        ),
        CommunityData(
            id = "2",
            label = "Community 2",
            icon = null,
            countPeople = 70,
            description = "Community Test Two",
            eventList = listOf()
        ),
    )
}