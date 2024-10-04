package ru.wb.domain.repository.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState

interface CommunityRepository {
    fun getCommunity(id: String): Flow<LoadState<CommunityData>>

    fun getCommunities(data: CommunitiesGetRequest? = null): Flow<LoadState<CommunityResponse>>

    fun subscribeOnCommunity(idUser: String, idCommunity: String) : Flow<LoadState<Boolean>>
}