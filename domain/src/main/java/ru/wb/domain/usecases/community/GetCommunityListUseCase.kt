package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.repisotory.model.CommunitiesGetRequest

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override suspend fun execute(
        data: CommunitiesGetRequest?
    ): List<CommunityData> = repository.getCommunities(data)
}

interface GetCommunityListUseCase {
    suspend fun execute(
        data: CommunitiesGetRequest? = null
    ): List<CommunityData>
}