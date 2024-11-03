package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.EventData
import ru.wb.domain.model.components.LoadState

interface GetEventDataUseCase {
    fun execute(id: String): Flow<LoadState<EventData>>
}