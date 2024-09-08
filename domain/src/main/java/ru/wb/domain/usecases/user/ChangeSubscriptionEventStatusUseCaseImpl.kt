package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.UserRepository

internal class ChangeSubscriptionEventStatusUseCaseImpl(
    private val repository: UserRepository
) : ChangeSubscriptionEventStatusUseCase {
    override fun execute(eventId: String): Flow<Boolean> {
        return repository.changeSubscriptionEventStatus(eventID = eventId)
    }
}