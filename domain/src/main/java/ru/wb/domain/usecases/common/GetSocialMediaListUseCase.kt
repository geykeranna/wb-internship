package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.components.LoadState

interface GetSocialMediaListUseCase {
    fun execute(type: String = "none"): Flow<LoadState<List<SocialMedia>>>
}