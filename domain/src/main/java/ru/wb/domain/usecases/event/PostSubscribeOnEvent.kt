package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.ResultResponse

interface PostSubscribeOnEvent {
    fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<ResultResponse>
}