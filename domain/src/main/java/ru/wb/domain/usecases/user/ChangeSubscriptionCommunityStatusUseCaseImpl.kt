package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserRepository

internal class ChangeSubscriptionCommunityStatusUseCaseImpl(
    private val repository: UserRepository
) : ChangeSubscriptionCommunityStatusUseCase {
    override fun execute(idCommunity: String): Flow<Boolean> {
        return repository.changeSubscriptionCommunityStatus(idCommunity = idCommunity)
    }
}