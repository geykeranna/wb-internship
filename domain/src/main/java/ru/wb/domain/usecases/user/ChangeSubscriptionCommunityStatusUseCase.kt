package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface ChangeSubscriptionCommunityStatusUseCase {
    fun execute(idCommunity: String): Flow<Boolean>
}