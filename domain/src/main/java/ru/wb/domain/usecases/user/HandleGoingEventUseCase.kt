package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface HandleGoingEventUseCase {
      fun execute(eventId: String): Flow<Boolean>
}