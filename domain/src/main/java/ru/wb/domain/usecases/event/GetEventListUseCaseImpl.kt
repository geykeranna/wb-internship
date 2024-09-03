package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.repository.EventRepository
import ru.wb.domain.repository.model.EventGetRequest

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
    ): Flow<List<EventData>> {
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