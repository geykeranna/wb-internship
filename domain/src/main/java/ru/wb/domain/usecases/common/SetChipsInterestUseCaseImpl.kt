package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository

internal class SetChipsInterestUseCaseImpl(
    private val repository: CommonRepository
) : SetChipsInterestUseCase {
    override fun execute(chips: List<String>): Flow<LoadState<Boolean>> = repository.setChipsInterest(chips = chips)
}