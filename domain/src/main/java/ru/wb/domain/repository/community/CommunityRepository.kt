package ru.wb.domain.repository.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState

interface CommunityRepository {
    fun getCommunity(id: String): Flow<LoadState<CommunityData>>

    fun getCommunities(request: CommunitiesGetRequest? = null): Flow<LoadState<CommunityGetResponse>>
}