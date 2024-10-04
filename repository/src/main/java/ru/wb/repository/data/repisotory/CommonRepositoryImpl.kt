package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.Content
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.components.LoadState
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.common.ContentRequest
import ru.wb.domain.repository.common.ContentResponse
import kotlin.random.Random

internal class CommonRepositoryImpl: CommonRepository {
    override fun getContent(data: ContentRequest): Flow<LoadState<ContentResponse>> {
        val response = ContentResponse(
            limit = 4,
            offset = 0,
            data = Content.defaultObject
        )
        return flowOf(LoadState.Success(response))
    }

    override fun getSocialMediaList(type: String): Flow<LoadState<List<SocialMedia>>> {
        return flowOf(LoadState.Success(List (10){ SocialMedia.defaultObject }))
    }

    override fun getCountryCodesList(type: String): Flow<LoadState<List<CountryCodes>>> {
        return flowOf(LoadState.Success(CountryCodes.defaultData))
    }

    override fun getChipsInterest(type: String): Flow<LoadState<List<String>>> {
        return flowOf(LoadState.Success(listOf(
            "Дизайн",
            "Продакт менеджмент",
            "Backend",
            "Frontend",
            "Mobile",
            "Web",
            "Тестирование",
            "Продажи",
            "Бизнес",
            "Маркетинг",
            "Безопасность",
            "Девопс",
            "Аналитика",
        )))
    }

    override fun setChipsInterest(chips: List<String>): Flow<LoadState<Boolean>> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(LoadState.Success(random))
    }
}