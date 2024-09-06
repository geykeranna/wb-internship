package ru.wb.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.Content
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.repository.model.ContentRequest

interface CommonRepository {
    fun getContent(data: ContentRequest): Flow<Content>

    fun getSocialMediaList(): Flow<List<SocialMedia>>

    fun getCountryCodesList(): Flow<List<CountryCodes>>

    fun getChipsInterest(): Flow<List<String>>
}