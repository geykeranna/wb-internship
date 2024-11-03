package ru.wb.repository.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.wb.repository.data.api.RetrofitClient
import ru.wb.repository.data.api.mappers.models.CommunityMapper
import ru.wb.repository.data.api.mappers.models.ContentItemsMapper
import ru.wb.repository.data.api.mappers.models.ContentMapper
import ru.wb.repository.data.api.mappers.models.CountryCodesMapper
import ru.wb.repository.data.api.mappers.models.EventMapper
import ru.wb.repository.data.api.mappers.models.LocationMapper
import ru.wb.repository.data.api.mappers.models.SocialMediaMapper
import ru.wb.repository.data.api.mappers.models.UserMapper
import ru.wb.repository.data.api.mappers.request.CommunityGetRequestMapper
import ru.wb.repository.data.api.mappers.request.ContentGetRequestMapper
import ru.wb.repository.data.api.mappers.request.EventGetRequestMapper
import ru.wb.repository.data.api.mappers.request.UsersGetRequestMapper
import ru.wb.repository.data.api.mappers.response.CommunityGetResponseMapper
import ru.wb.repository.data.api.mappers.response.ContentGetResponseMapper
import ru.wb.repository.data.api.mappers.response.EventGetResponseMapper
import ru.wb.repository.data.api.mappers.response.UserGetResponseMapper

val apiModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().commonApi }
    single { get<RetrofitClient>().communityApi }
    single { get<RetrofitClient>().userApi }
    single { get<RetrofitClient>().eventApi }
    single { get<RetrofitClient>().loginApi }
}

val mapperModule = module {
    singleOf(::CountryCodesMapper)
    singleOf(::LocationMapper)
    singleOf(::SocialMediaMapper)
    singleOf(::UserMapper)
    singleOf(::CommunityMapper)
    singleOf(::EventMapper)
    singleOf(::ContentItemsMapper)
    singleOf(::ContentMapper)

    singleOf(::CommunityGetRequestMapper)
    singleOf(::ContentGetRequestMapper)
    singleOf(::EventGetRequestMapper)
    singleOf(::UsersGetRequestMapper)

    singleOf(::CommunityGetResponseMapper)
    singleOf(::ContentGetResponseMapper)
    singleOf(::EventGetResponseMapper)
    singleOf(::UserGetResponseMapper)
}

//val networkModule = listOf(apiModule, mapperModule)