package ru.wb.repository.data.repisotory

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ru.wb.domain.model.Content
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.repository.CommonRepository
import ru.wb.domain.repository.model.ContentRequest

internal class CommonRepositoryImpl: CommonRepository {
    override fun getContent(data: ContentRequest): Flow<Content> {
        return flowOf(Content.defaultObject)
    }

    override fun getSocialMediaList(): Flow<List<SocialMedia>> {
        return flowOf(List (10){ SocialMedia.defaultObject })
    }

    override fun getCountryCodesList(): Flow<List<CountryCodes>> {
        return flowOf(CountryCodes.defaultData)
    }

    override fun getChipsInterest(): Flow<List<String>> {
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
}