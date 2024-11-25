package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.components.LoadState

interface GetCountryCodesListUseCase {
    fun execute(type: String = "none"): Flow<LoadState<List<CountryCodes>>>
}