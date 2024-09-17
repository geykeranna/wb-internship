package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserRepository

internal class GetSubscriptionCommunityStatusUseCaseImpl(
    private val repository: UserRepository
) : GetSubscriptionCommunityStatusUseCase {
    override fun execute(idCommunity: String): Flow<Boolean> {
        return repository.getSubscriptionCommunityStatus(idCommunity = idCommunity)
    }
}