package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

internal class GetSubscriptionCommunityStatusUseCaseImpl(
    private val repository: UserRepository
) : GetSubscriptionCommunityStatusUseCase {
    override fun execute(idCommunity: String) : Flow<LoadState<UserSubscribeStatusResponse>> {
        return repository.getSubscriptionCommunityStatus(idCommunity = idCommunity)
    }
}