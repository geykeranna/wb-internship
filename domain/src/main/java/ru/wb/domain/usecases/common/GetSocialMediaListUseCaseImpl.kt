package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.repository.CommonRepository

internal class GetSocialMediaListUseCaseImpl(
    private val repository: CommonRepository
) : GetSocialMediaListUseCase {
    override fun execute(): Flow<List<SocialMedia>> = repository.getSocialMediaList()
}