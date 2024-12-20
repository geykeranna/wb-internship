package ru.wb.repository.data.api.mappers.response

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.mappers.models.EventItemMapper
import ru.wb.repository.data.api.services.event.EventGetResponse

internal class EventGetResponseMapper(
    private val eventItemMapper: EventItemMapper,
) : Mapper<EventGetResponse, ru.wb.domain.repository.event.EventGetResponse>{
    override fun transformToDomain(
        data: EventGetResponse
    ): ru.wb.domain.repository.event.EventGetResponse {
        return ru.wb.domain.repository.event.EventGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { eventItemMapper.transformToDomain(it) },
        )
    }

    override fun transformToRepository(
        data: ru.wb.domain.repository.event.EventGetResponse
    ): EventGetResponse {
        return EventGetResponse(
            limit = data.limit,
            offset = data.offset,
            data = data.data.map { eventItemMapper.transformToRepository(it) },
        )
    }
}