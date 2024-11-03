package ru.wb.repository.data.api.mappers.request

import ru.wb.repository.data.api.mappers.Mapper
import ru.wb.repository.data.api.services.common.ContentGetRequest

internal class ContentGetRequestMapper: Mapper<ContentGetRequest, ru.wb.domain.repository.common.ContentGetRequest>{
    override fun transformToDomain(
        data: ContentGetRequest
    ): ru.wb.domain.repository.common.ContentGetRequest {
        return ru.wb.domain.repository.common.ContentGetRequest(
            limit = data.limit,
            offset = data.offset,
            filter = data.filter,
            search = data.search,
        )
    }

    override fun transformToRepository(
        data: ru.wb.domain.repository.common.ContentGetRequest
    ): ContentGetRequest {
        return ContentGetRequest(
            limit = data.limit,
            offset = data.offset,
            filter = data.filter,
            search = data.search,
        )
    }
}