package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventsByGroup
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.model.EventGetRequest

internal class GetEventListByGroupUseCaseImpl(
    private val repository: EventRepository
) : GetEventListByGroupUseCase {
    override suspend fun execute(
        userId: String?,
        date: String?
    ) : List<EventsByGroup> {
        val listByGroup = mutableListOf<EventsByGroup>()
        when(userId){
            null -> {
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(state = "all")),
                        group = "Все встречи"
                    )
                )
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(state = "active")),
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
                            )),
                        group = "Запланированы"
                    )
                )
                listByGroup.add(
                    EventsByGroup(
                        listOfEvents = repository.getEvents(EventGetRequest(
                            state = "active",
                            endDate = date
                        )),
                        group = "Прошли"
                    )
                )
            }
        }
        return listByGroup
    }
}

interface GetEventListByGroupUseCase {
    suspend fun execute(userId: String? = null,
                        date: String? = null
    ): List<EventsByGroup>
}