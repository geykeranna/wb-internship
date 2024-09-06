package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.repository.CommonRepository

internal class GetChipsInterestUseCaseImpl(
    private val repository: CommonRepository
) : GetChipsInterestUseCase {
    override fun execute(): Flow<List<String>> = repository.getChipsInterest()
}