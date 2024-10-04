package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventResponse

interface GetEventListUseCase {
    fun execute(
        limit: Int? = null,
        offset: Int? = null,
        query: String? = null,
        idUser: String? = null,
        idCommunity: String? = null,
        state: String? = null,
        startDate: String? = null,
        endDate: String? = null,
    ): Flow<LoadState<EventResponse>>
}