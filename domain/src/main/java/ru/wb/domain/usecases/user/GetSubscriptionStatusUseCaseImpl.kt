package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.UserRepository

internal class GetSubscriptionStatusUseCaseImpl(
    private val repository: UserRepository
) : GetSubscriptionStatusUseCase {
    override fun execute(idCommunity: String): Flow<Boolean> {
        return repository.getSubscriptionStatus(idCommunity = idCommunity)
    }
}