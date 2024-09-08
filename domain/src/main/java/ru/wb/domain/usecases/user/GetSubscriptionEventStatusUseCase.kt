package ru.wb.domain.usecases.user

import kotlinx.coroutines.flow.Flow

interface GetSubscriptionEventStatusUseCase {
    fun execute(idEvent: String): Flow<Boolean>
}