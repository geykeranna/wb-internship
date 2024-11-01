package ru.wb.repository.data.api.services.common

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import ru.wb.repository.data.api.model.CountryCodes
import ru.wb.repository.data.api.model.SocialMedia

internal interface CommonService {
    @GET("/content")
    fun getContent(
        @Body data: ContentGetRequest
    ): ContentGetResponse

    @GET("/common/social")
    fun getSocialMediaList(
        @Query("type") type: String
    ): List<SocialMedia>

    @GET("/common/phone_codes")
    fun getCountryCodesList(
        @Query("type") type: String
    ): List<CountryCodes>

    @GET("/interesting_list")
    fun getChipsInterest(
        @Query("type") type: String
    ): List<String>
}