package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserRepository
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

internal class ChangeSubscriptionCommunityStatusUseCaseImpl(
    private val repository: UserRepository
) : ChangeSubscriptionCommunityStatusUseCase {
    override fun execute(idCommunity: String) : Flow<UserSubscribeStatusResponse> {
        return repository.changeSubscriptionCommunityStatus(idCommunity = idCommunity)
    }
}