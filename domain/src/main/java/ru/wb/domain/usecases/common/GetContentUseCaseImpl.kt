package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.Content
import ru.wb.domain.repository.CommonRepository
import ru.wb.domain.repository.model.ContentRequest

internal class GetContentUseCaseImpl(
    private val repository: CommonRepository
) : GetContentUseCase {
    override fun execute(
        limit: Int?,
        offset: Int?,
        filter: List<String>?,
        search: String?
    ): Flow<Content> = repository.getContent(ContentRequest(
        limit = limit,
        offset = offset,
        filter = filter,
        search = search,
    ))
}