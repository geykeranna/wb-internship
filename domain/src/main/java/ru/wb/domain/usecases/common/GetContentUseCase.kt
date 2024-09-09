package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.Content

interface GetContentUseCase {
    fun execute(
        limit: Int? = null,
        offset: Int? = null,
        filter: List<String>? = null,
        search: String? = null,
    ): Flow<Content>
}