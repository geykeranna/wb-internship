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
        userId: String?,
        state: String?,
        startDate: String?,
        endDate: String?,
    ): Flow<List<EventData>> {
        return repository.getEvents(
            EventGetRequest(
                limit = limit,
                offset = offset,
                query = query,
                userId = userId,
                state = state,
                startDate = startDate,
                endDate = endDate
            )
        )
    }
}