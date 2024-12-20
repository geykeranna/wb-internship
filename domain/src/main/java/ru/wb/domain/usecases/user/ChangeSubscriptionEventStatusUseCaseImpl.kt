package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

internal class ChangeSubscriptionEventStatusUseCaseImpl(
    private val repository: UserRepository
) : ChangeSubscriptionEventStatusUseCase {
    override fun execute(eventId: String) : Flow<LoadState<UserSubscribeStatusResponse>> {
        return repository.changeSubscriptionEventStatus(eventID = eventId)
    }
}