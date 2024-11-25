package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.repository.community.CommunitiesGetRequest
import ru.wb.domain.repository.community.CommunityGetResponse

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        idEvent: String?,
        idUser: String?,
    ): Flow<LoadState<CommunityGetResponse>> = repository.getCommunities(
        CommunitiesGetRequest(
            limit = limit,
            offset = offset,
            query = query,
            idEvent = idEvent,
            idUser = idUser,
        )
    )
}