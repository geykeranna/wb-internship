package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

internal class GetSubscriptionEventStatusUseCaseImpl(
    private val repository: UserRepository
) : GetSubscriptionEventStatusUseCase {
    override fun execute(idEvent: String) : Flow<LoadState<UserSubscribeStatusResponse>> {
        return repository.getSubscriptionEventStatus(idEvent = idEvent)
    }
}