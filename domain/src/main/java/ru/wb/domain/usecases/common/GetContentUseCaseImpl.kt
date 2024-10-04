package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.common.ContentRequest
import ru.wb.domain.repository.common.ContentResponse

internal class GetContentUseCaseImpl(
    private val repository: CommonRepository
) : GetContentUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        filter: List<String>?,
        search: String?
    ): Flow<LoadState<ContentResponse>> = repository.getContent(
        ContentRequest(
            limit = limit,
            offset = offset,
            filter = filter,
            search = search,
        )
    )
}