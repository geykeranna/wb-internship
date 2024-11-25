package ru.wb.repository.data.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.wb.domain.repository.common.CommonRepository
import ru.wb.domain.repository.community.CommunityRepository
import ru.wb.domain.repository.event.EventRepository
import ru.wb.domain.repository.LoginRepository
import ru.wb.domain.repository.user.UserRepository
import ru.wb.repository.data.repisotory.CommonRepositoryImpl
import ru.wb.repository.data.repisotory.UserRepositoryImpl
import ru.wb.repository.data.repisotory.EventRepositoryImpl
import ru.wb.repository.data.repisotory.CommunityRepositoryImpl
import ru.wb.repository.data.repisotory.LoginRepositoryImpl

val repositoryModule = module {
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
    singleOf(::EventRepositoryImpl) { bind<EventRepository>() }
    singleOf(::CommunityRepositoryImpl) { bind<CommunityRepository>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::CommonRepositoryImpl) { bind<CommonRepository>() }
}