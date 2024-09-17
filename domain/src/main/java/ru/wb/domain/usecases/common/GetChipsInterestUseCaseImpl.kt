package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.common.CommonRepository

internal class GetChipsInterestUseCaseImpl(
    private val repository: CommonRepository
) : GetChipsInterestUseCase {
    override fun execute(type: String): Flow<List<String>> = repository.getChipsInterest(type = type)
}