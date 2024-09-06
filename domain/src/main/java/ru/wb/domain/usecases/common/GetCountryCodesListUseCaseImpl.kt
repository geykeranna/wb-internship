package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.repository.CommonRepository

internal class GetCountryCodesListUseCaseImpl(
    private val repository: CommonRepository
) : GetCountryCodesListUseCase {
    override fun execute(): Flow<List<CountryCodes>> = repository.getCountryCodesList()
}