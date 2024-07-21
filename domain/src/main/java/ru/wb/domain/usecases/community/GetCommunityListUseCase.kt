package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository

class GetCommunityListUseCase(private val repository: CommunityRepository) {
    suspend fun execute(query: String?): List<CommunityData> = repository.getCommunities(query)
}