package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.common.ContentGetRequest
import ru.wb.domain.repository.common.ContentGetResponse

internal class GetContentUseCaseImpl(
    private val repository: CommonRepository
) : GetContentUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        filter: List<String>?,
        search: String?
    ): Flow<LoadState<ContentGetResponse>> = repository.getContent(
        ContentGetRequest(
            limit = limit,
            offset = offset,
            filter = filter,
            search = search,
        )
    )
}