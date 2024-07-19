package ru.testtask.testapplication.domain.di.modules

import org.koin.dsl.module
import ru.testtask.testapplication.domain.repisotory.CommunityRepository
import ru.testtask.testapplication.repository.data.repisotory.CommunityRepositoryImpl

val dataModule = module {
    single<CommunityRepository> { CommunityRepositoryImpl() }
}
