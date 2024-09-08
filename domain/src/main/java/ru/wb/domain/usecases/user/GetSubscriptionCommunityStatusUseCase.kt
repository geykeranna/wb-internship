package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface GetSubscriptionCommunityStatusUseCase {
    fun execute(idCommunity: String): Flow<Boolean>
}