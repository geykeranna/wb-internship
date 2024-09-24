package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.ResultResponse
import ru.wb.domain.repository.event.EventRepository

internal class PostSubscribeOnEventImpl(
    private val repository: EventRepository
): PostSubscribeOnEvent {
    override fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<ResultResponse> = repository.subscribeOnEvent(
        idUser = idUser,
        idEvent = idEvent,
    )
}