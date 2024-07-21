package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData
import ru.wb.domain.repisotory.CommunityRepository

class GetCommunityDataUseCase(private val repository: CommunityRepository) {
    suspend fun execute(id: String): CommunityData = repository.getCommunity(id = id)
}