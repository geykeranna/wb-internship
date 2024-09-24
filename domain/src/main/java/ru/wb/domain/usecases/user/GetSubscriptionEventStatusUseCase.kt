package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.user.UserSubscribeStatusResponse

interface GetSubscriptionEventStatusUseCase {
    fun execute(idEvent: String) : Flow<UserSubscribeStatusResponse>
}