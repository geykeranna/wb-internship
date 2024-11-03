package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData
import ru.wb.domain.model.components.LoadState

interface GetCommunityDataUseCase {
    fun execute(id: String): Flow<LoadState<CommunityData>>
}