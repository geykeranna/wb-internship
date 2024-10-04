package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.event.EventRepository

internal class PostSubscribeOnEventImpl(
    private val repository: EventRepository
): PostSubscribeOnEvent {
    override fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<LoadState<Boolean>> = repository.subscribeOnEvent(
        idUser = idUser,
        idEvent = idEvent,
    )
}