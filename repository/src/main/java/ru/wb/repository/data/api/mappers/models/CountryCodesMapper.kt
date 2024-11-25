package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.CountryCodes

internal class CountryCodesMapper: Mapper<CountryCodes, ru.wb.domain.model.CountryCodes> {
    override fun transformToDomain(data: CountryCodes): ru.wb.domain.model.CountryCodes {
        return ru.wb.domain.model.CountryCodes(
            country = data.country,
            countryCode = data.countryCode,
            flagIcon = data.flagIcon,
            mask = data.mask
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.CountryCodes): CountryCodes {
        return CountryCodes(
            country = data.country,
            countryCode = data.countryCode,
            flagIcon = data.flagIcon,
            mask = data.mask
        )
    }
}