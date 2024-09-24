package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.Content
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.repository.ResultResponse
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.common.ContentRequest
import ru.wb.domain.repository.common.ContentResponse
import kotlin.random.Random

internal class CommonRepositoryImpl: CommonRepository {
    override fun getContent(data: ContentRequest): Flow<ContentResponse> {
        val response = ContentResponse(
            limit = 4,
            offset = 0,
            data = Content.defaultObject
        )
        return flowOf(response)
    }

    override fun getSocialMediaList(type: String): Flow<List<SocialMedia>> {
        return flowOf(List (10){ SocialMedia.defaultObject })
    }

    override fun getCountryCodesList(type: String): Flow<List<CountryCodes>> {
        return flowOf(CountryCodes.defaultData)
    }

    override fun getChipsInterest(type: String): Flow<List<String>> {
        return flowOf(listOf(
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
        ))
    }

    override fun setChipsInterest(chips: List<String>): Flow<ResultResponse> {
        val random: Boolean = Random.nextBoolean()
        return flowOf(
            when(random) {
                true -> ResultResponse.SUCCESS
                else -> ResultResponse.ERROR
            }
        )
    }
}