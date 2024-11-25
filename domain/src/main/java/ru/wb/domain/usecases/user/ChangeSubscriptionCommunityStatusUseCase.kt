package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

import ru.wb.domain.repository.user.UserSubscribeStatusResponse

interface ChangeSubscriptionCommunityStatusUseCase {
    fun execute(communityId: String) : Flow<LoadState<UserSubscribeStatusResponse>>
}