package ru.wb.repository.data.api.mappers.request

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.services.event.EventGetRequest

internal class EventGetRequestMapper: Mapper<EventGetRequest, ru.wb.domain.repository.event.EventGetRequest> {
    override fun transformToDomain(data: EventGetRequest): ru.wb.domain.repository.event.EventGetRequest {
        return ru.wb.domain.repository.event.EventGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            idUser = data.idUser,
            idCommunity = data.idCommunity,
            state = data.state,
            startDate = data.startDate,
            endDate = data.endDate,
        )
    }

    override fun transformToRepository(data: ru.wb.domain.repository.event.EventGetRequest): EventGetRequest {
        return EventGetRequest(
            limit = data.limit,
            offset = data.offset,
            query = data.query,
            idUser = data.idUser,
            idCommunity = data.idCommunity,
            state = data.state,
            startDate = data.startDate,
            endDate = data.endDate,
        )
    }
}