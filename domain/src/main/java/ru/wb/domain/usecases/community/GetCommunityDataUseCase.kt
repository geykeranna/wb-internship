package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData

interface GetCommunityDataUseCase {
    suspend fun execute(id: String): Flow<CommunityData>
}