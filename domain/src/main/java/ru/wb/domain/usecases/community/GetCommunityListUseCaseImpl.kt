package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.CommunityRepository
import ru.wb.domain.repository.model.CommunitiesGetRequest

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
    ): Flow<List<CommunityData>> = repository.getCommunities(CommunitiesGetRequest(
        limit = limit,
        offset = offset,
        query = query,
    ))
}