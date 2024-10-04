package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository

internal class GetSocialMediaListUseCaseImpl(
    private val repository: CommonRepository
) : GetSocialMediaListUseCase {
    override fun execute(type: String): Flow<LoadState<List<SocialMedia>>> {
        return repository.getSocialMediaList(type = type)
    }
}