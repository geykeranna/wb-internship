package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState

interface SetChipsInterestUseCase {
    fun execute(chips: List<String>): Flow<LoadState<Boolean>>
}