package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface GetSubscriptionStatusUseCase {
    fun execute(idCommunity: String): Flow<Boolean>
}