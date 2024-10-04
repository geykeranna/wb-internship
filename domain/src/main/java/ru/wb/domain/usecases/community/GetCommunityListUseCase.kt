package ru.wb.domain.usecases.community

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.community.CommunityResponse

interface GetCommunityListUseCase {
    fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        idEvent: String? = null,
        idUser: String? = null,
    ): Flow<LoadState<CommunityResponse>>
}