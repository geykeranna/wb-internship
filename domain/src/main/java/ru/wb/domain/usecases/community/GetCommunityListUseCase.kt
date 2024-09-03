package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CommunityData

interface GetCommunityListUseCase {
    fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        idEvent: String? = null,
        idUser: String? = null,
    ): Flow<List<CommunityData>>
}