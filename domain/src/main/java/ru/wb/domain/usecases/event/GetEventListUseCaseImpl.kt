package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.event.EventGetRequest
import ru.wb.domain.repository.event.EventGetResponse

internal class GetEventListUseCaseImpl(
    private val repository: EventRepository
) : GetEventListUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        query: String?,
        idUser: String?,
        idCommunity: String?,
        state: String?,
        startDate: String?,
        endDate: String?,
    ): Flow<LoadState<EventGetResponse>> {
        return repository.getEvents(
            EventGetRequest(
                limit = limit,
                offset = offset,
                query = query,
                idUser = idUser,
                idCommunity = idCommunity,
                state = state,
                startDate = startDate,
                endDate = endDate
            )
        )
    }
}