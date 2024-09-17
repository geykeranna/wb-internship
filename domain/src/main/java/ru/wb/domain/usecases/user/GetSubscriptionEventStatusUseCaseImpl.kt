package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserRepository

internal class GetSubscriptionEventStatusUseCaseImpl(
    private val repository: UserRepository
) : GetSubscriptionEventStatusUseCase {
    override fun execute(idEvent: String): Flow<Boolean> {
        return repository.getSubscriptionEventStatus(idEvent = idEvent)
    }
}