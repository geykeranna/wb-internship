package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow

interface GetChipsInterestUseCase {
    fun execute(type: String = "none"): Flow<List<String>>
}