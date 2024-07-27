package ru.wb.domain.usecases.event

import ru.wb.domain.model.EventData

interface GetEventDataUseCase {
    suspend fun execute(id: String): EventData
}