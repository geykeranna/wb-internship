package ru.wb.domain.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.wb.domain.repisotory.CommunityRepository
import ru.wb.domain.repisotory.EventRepository
import ru.wb.domain.repisotory.LoginRepository
import ru.wb.domain.repisotory.UserRepository
import ru.wb.domain.stabs.UserRepositoryStubs
import ru.wb.domain.stabs.LoginRepositoryStubs
import ru.wb.domain.stabs.CommunityRepositoryStubs
import ru.wb.domain.stabs.EventRepositoryStubs

val dataModule = module {
    factoryOf(::LoginRepositoryStubs) { bind<LoginRepository>() }
    factoryOf(::EventRepositoryStubs) { bind<EventRepository>()}
    factoryOf(::CommunityRepositoryStubs) { bind<CommunityRepository>()}
    factoryOf(::UserRepositoryStubs) { bind<UserRepository>()}
}
