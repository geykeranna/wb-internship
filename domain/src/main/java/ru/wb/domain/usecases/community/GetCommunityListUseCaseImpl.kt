package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override suspend fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
    ): Flow<List<CommunityData>> = repository.getCommunities(CommunitiesGetRequest(
        limit = limit,
        offset = offset,
        query = query,
    ))
}