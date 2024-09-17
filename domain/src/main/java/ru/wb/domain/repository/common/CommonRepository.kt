package ru.wb.domain.repository.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia

interface CommonRepository {
    fun getContent(data: ContentRequest): Flow<ContentResponse>

    fun getSocialMediaList(type: String = "none"): Flow<List<SocialMedia>>

    fun getCountryCodesList(type: String = "none"): Flow<List<CountryCodes>>

    fun getChipsInterest(type: String = "none"): Flow<List<String>>
}