package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository

internal class GetCommunityDataUseCaseImpl(private val repository: CommunityRepository) : GetCommunityDataUseCase{
    override suspend fun execute(id: String): CommunityData = repository.getCommunity(id = id)
}

interface GetCommunityDataUseCase {
    suspend fun execute(id: String): CommunityData
}