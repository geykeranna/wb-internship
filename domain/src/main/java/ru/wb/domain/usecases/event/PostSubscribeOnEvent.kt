package ru.wb.domain.usecases.event

import kotlinx.coroutines.flow.Flow

interface PostSubscribeOnEvent {
    fun execute(
        idUser: String,
        idEvent: String,
    ): Flow<Boolean>
}