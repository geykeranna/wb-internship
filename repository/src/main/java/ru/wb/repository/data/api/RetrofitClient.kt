package ru.wb.repository.data.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.wb.repository.data.api.services.common.CommonService
import ru.wb.repository.data.api.services.community.CommunityService
import ru.wb.repository.data.api.services.event.EventService
import ru.wb.repository.data.api.services.login.LoginService
import ru.wb.repository.data.api.services.user.UserService
import ru.wb.repository.data.utils.BASE_URL

internal class RetrofitClient {
    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val commonApi: CommonService = retrofit.create(CommonService::class.java)
    val eventApi: EventService = retrofit.create(EventService::class.java)
    val communityApi: CommunityService = retrofit.create(CommunityService::class.java)
    val userApi: UserService = retrofit.create(UserService::class.java)
    val loginApi: LoginService = retrofit.create(LoginService::class.java)
}