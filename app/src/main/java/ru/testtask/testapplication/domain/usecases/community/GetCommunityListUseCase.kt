package ru.testtask.testapplication.domain.usecases.community

import ru.testtask.testapplication.data.model.CommunityData
import ru.testtask.testapplication.domain.repisotory.CommunityRepository

class GetCommunityListUseCase(private val repository: CommunityRepository) {
    suspend fun execute(): List<CommunityData> = repository.getCommunities()
}