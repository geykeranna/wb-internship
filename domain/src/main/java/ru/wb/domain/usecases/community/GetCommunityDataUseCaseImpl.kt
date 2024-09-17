package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.repository.community.CommunityRepository

internal class GetCommunityDataUseCaseImpl(
    private val repository: CommunityRepository
) : GetCommunityDataUseCase{
    override fun execute(id: String): Flow<CommunityData> = repository.getCommunity(id = id)
}