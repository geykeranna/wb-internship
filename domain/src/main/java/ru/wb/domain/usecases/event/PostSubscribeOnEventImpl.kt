package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.EventRepository

internal class PostSubscribeOnEventImpl(
    private val repository: EventRepository
): PostSubscribeOnEvent {
    override fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<Boolean> = repository.subscribeOnEvent(
        idUser = idUser,
        idEvent = idEvent,
    )
}