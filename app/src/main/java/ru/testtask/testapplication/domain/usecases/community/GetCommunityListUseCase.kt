package ru.testtask.testapplication.domain.usecases.community

import ru.testtask.testapplication.repository.data.model.CommunityData
import ru.testtask.testapplication.domain.repisotory.CommunityRepository

class GetCommunityListUseCase(private val repository: CommunityRepository) {
    suspend fun execute(query: String?): List<CommunityData> = repository.getCommunities(query)
}