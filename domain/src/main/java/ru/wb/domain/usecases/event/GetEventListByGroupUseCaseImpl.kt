package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.toList
import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

internal class GetEventListByGroupUseCaseImpl(
    private val repository: EventRepository
) : GetEventListByGroupUseCase {
    override suspend fun execute(
        userId: String?,
        date: String?
    ) : Flow<List<EventsByGroup>> {
        val listByGroup = mutableListOf<EventsByGroup>()
        when(userId){
            null -> {
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(state = "all")).last(),
                        group = "Все встречи"
                    )
                )
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(state = "active")).last(),
                        group = "Активные"
                    )
                )
            }
            else -> {
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(
                            userId = userId,
                            startDate = date
                            )).last(),
                        group = "Запланированы"
                    )
                )
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(
                            state = "active",
                            endDate = date
                        )).last(),
                        group = "Прошли"
                    )
                )
            }
        }
        return flowOf(listByGroup)
    }
}