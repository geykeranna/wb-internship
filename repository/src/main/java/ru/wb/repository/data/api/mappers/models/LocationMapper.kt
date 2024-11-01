package ru.wb.repository.data.api.mappers.models

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.model.Location

internal class LocationMapper: Mapper<Location, ru.wb.domain.model.Location> {
    override fun transformToDomain(data: Location): ru.wb.domain.model.Location {
        return ru.wb.domain.model.Location(
            id = data.id,
            city = data.city,
            address = data.address,
            metro = data.metro,
            icon = data.icon,
            fullAddress = data.fullAddress,
            coordinate = data.coordinate,
        )
    }

    override fun transformToRepository(data: ru.wb.domain.model.Location): Location {
        return Location(
            id = data.id,
            city = data.city,
            address = data.address,
            metro = data.metro,
            icon = data.icon,
            fullAddress = data.fullAddress,
            coordinate = data.coordinate,
        )
    }
}