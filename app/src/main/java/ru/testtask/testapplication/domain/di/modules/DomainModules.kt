package ru.testtask.testapplication.domain.di.modules

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.testtask.testapplication.domain.usecases.community.GetCommunityDataUseCase
import ru.testtask.testapplication.domain.usecases.community.GetCommunityListUseCase
import ru.testtask.testapplication.domain.usecases.event.GetEventDataUseCase
import ru.testtask.testapplication.domain.usecases.event.GetEventListByGroupUseCase
import ru.testtask.testapplication.domain.usecases.event.GetEventListUseCase
import ru.testtask.testapplication.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.testtask.testapplication.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.testtask.testapplication.domain.usecases.user.GetUserDataUseCase
import ru.testtask.testapplication.domain.usecases.user.GetUserListUseCase

val domainModules = module {
    factoryOf(::GetUserDataUseCase)
    factoryOf(::GetUserListUseCase)

    factoryOf(::GetEventDataUseCase)
    factoryOf(::GetEventListUseCase)
    factoryOf(::GetEventListByGroupUseCase)

    factoryOf(::GetCommunityDataUseCase)
    factoryOf(::GetCommunityListUseCase)

    factoryOf(::GetCurrentPhoneNumberUseCase)
    factoryOf(::SendPinCodeOnPhoneUseCase)
}