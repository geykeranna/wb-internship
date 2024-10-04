package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface PostSubscribeOnEvent {
    fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<LoadState<Boolean>>
}