package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.ResultResponse

interface SetChipsInterestUseCase {
    fun execute(chips: List<String>): Flow<ResultResponse>
}