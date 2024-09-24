package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

interface GetSubscriptionCommunityStatusUseCase {
    fun execute(idCommunity: String) : Flow<UserSubscribeStatusResponse>
}