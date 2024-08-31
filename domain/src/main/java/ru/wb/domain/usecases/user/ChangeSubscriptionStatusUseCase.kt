package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface ChangeSubscriptionStatusUseCase {
    fun execute(idCommunity: String): Flow<Boolean>
}