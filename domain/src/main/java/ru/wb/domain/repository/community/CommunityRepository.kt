package ru.wb.domain.repository.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.ResultResponse

interface CommunityRepository {
    fun getCommunity(id: String): Flow<CommunityData>

    fun getCommunities(data: CommunitiesGetRequest? = null): Flow<CommunityResponse>

    fun subscribeOnCommunity(idUser: String, idCommunity: String) : Flow<ResultResponse>
}