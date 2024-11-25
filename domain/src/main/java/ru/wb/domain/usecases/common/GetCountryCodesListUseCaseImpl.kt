package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository

internal class GetCountryCodesListUseCaseImpl(
    private val repository: CommonRepository
) : GetCountryCodesListUseCase {
    override fun execute(type: String): Flow<LoadState<List<CountryCodes>>> {
        return repository.getCountryCodesList(type = type)
    }
}