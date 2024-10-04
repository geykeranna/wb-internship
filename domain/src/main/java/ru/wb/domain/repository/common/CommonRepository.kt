package ru.wb.domain.repository.common

import kotlinx.coroutines.flow.Flow
import ru.wb.domain.model.CountryCodes
import ru.wb.domain.model.SocialMedia
import ru.wb.domain.model.components.LoadState

interface CommonRepository {
    fun getContent(data: ContentRequest): Flow<LoadState<ContentResponse>>

    fun getSocialMediaList(type: String = "none"): Flow<LoadState<List<SocialMedia>>>

    fun getCountryCodesList(type: String = "none"): Flow<LoadState<List<CountryCodes>>>

    fun getChipsInterest(type: String = "none"): Flow<LoadState<List<String>>>

    fun setChipsInterest(chips: List<String>) : Flow<LoadState<Boolean>>
}