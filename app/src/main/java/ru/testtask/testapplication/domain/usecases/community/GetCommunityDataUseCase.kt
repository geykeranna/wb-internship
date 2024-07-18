package ru.testtask.testapplication.domain.usecases.community

import ru.testtask.testapplication.repository.data.model.CommunityData
import ru.testtask.testapplication.domain.repisotory.CommunityRepository

class GetCommunityDataUseCase(private val repository: CommunityRepository) {
    suspend fun execute(id: String): CommunityData = repository.getCommunity(id = id)
}