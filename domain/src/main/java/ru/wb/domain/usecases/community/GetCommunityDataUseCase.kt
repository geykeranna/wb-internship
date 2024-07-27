package ru.wb.domain.usecases.community

import ru.wb.domain.model.CommunityData

interface GetCommunityDataUseCase {
    suspend fun execute(id: String): CommunityData
}