package ru.testtask.testapplication.domain.usecases.community

import ru.testtask.testapplication.domain.repisotory.CommunityRepository
import ru.testtask.testapplication.repository.data.model.CommunityData

class GetCommunityListBySearchQueryUseCase(private val repository: CommunityRepository) {
    suspend fun execute(query: String): List<CommunityData> = repository.getCommunitiesBySearch(query = query)
}