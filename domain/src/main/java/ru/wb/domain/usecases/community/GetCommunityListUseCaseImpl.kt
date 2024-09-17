package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityResponse

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        idEvent: String?,
        idUser: String?,
    ): Flow<CommunityResponse> = repository.getCommunities(
        CommunitiesGetRequest(
            limit = limit,
            offset = offset,
            query = query,
            idEvent = idEvent,
            idUser = idUser,
        )
    )
}