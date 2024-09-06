package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes

interface GetCountryCodesListUseCase {
    fun execute(): Flow<List<CountryCodes>>
}