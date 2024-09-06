package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow

interface GetChipsInterestUseCase {
    fun execute(): Flow<List<String>>
}