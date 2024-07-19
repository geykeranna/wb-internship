package ru.testtask.testapplication.domain.di.modules

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.testtask.testapplication.domain.repisotory.CommunityRepository
import ru.testtask.testapplication.domain.repisotory.EventRepository
import ru.testtask.testapplication.domain.repisotory.LoginRepository
import ru.testtask.testapplication.domain.repisotory.UserRepository
import ru.testtask.testapplication.repository.data.repisotory.CommunityRepositoryImpl
import ru.testtask.testapplication.repository.data.repisotory.EventRepositoryImpl
import ru.testtask.testapplication.repository.data.repisotory.LoginRepositoryImpl
import ru.testtask.testapplication.repository.data.repisotory.UserRepositoryImpl

val dataModule = module {
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>()}
    singleOf(::EventRepositoryImpl) { bind<EventRepository>()}
    singleOf(::CommunityRepositoryImpl) { bind<CommunityRepository>()}
    singleOf(::UserRepositoryImpl) { bind<UserRepository>()}
}
