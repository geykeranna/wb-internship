package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.ResultResponse
import ru.wb.domain.repository.common.CommonRepository

internal class SetChipsInterestUseCaseImpl(
    private val repository: CommonRepository
) : SetChipsInterestUseCase {
    override fun execute(chips: List<String>): Flow<ResultResponse> = repository.setChipsInterest(chips = chips)
}