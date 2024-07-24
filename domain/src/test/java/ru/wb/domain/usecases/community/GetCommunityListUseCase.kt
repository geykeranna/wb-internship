package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository

internal class GetCommunityListUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityListUseCase {
    override suspend fun execute(query: String?): List<CommunityData> = repository.getCommunities(query)
}

interface GetCommunityListUseCase {
    suspend fun execute(query: String?): List<CommunityData>
}