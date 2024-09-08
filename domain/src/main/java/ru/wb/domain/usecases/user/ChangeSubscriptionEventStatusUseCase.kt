package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface ChangeSubscriptionEventStatusUseCase {
      fun execute(eventId: String): Flow<Boolean>
}