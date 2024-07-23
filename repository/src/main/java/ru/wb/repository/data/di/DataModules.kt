package ru.wb.repository.data.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.repisotory.UserRepository
import ru.wb.repository.data.repisotory.UserRepositoryImpl
import ru.wb.repository.data.repisotory.EventRepositoryImpl
import ru.wb.repository.data.repisotory.CommunityRepositoryImpl
import ru.wb.repository.data.repisotory.LoginRepositoryImpl

val dataModule = module {
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>()}
    singleOf(::EventRepositoryImpl) { bind<EventRepository>()}
    singleOf(::CommunityRepositoryImpl) { bind<CommunityRepository>()}
    singleOf(::UserRepositoryImpl) { bind<UserRepository>()}
}
