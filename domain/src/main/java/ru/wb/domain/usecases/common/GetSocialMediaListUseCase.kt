package ru.wb.domain.usecases.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.SocialMedia

interface GetSocialMediaListUseCase {
    fun execute(type: String = "none"): Flow<List<SocialMedia>>
}