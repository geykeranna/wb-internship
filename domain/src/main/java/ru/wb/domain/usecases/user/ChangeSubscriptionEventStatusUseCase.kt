package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

interface ChangeSubscriptionEventStatusUseCase {
      fun execute(eventId: String) : Flow<LoadState<UserSubscribeStatusResponse>>
}