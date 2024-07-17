package ru.testtask.testapplication.di.modules

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
    factory<GetUserDataUseCase> { GetUserDataUseCase(repository = get()) }
    factory<GetUserListUseCase> { GetUserListUseCase(repository = get()) }

    factory<GetEventDataUseCase> { GetEventDataUseCase(repository = get()) }
    factory<GetEventListUseCase> { GetEventListUseCase(repository = get()) }
    factory<GetEventListByGroupUseCase> { GetEventListByGroupUseCase(repository = get()) }

    factory<GetCommunityDataUseCase> { GetCommunityDataUseCase(repository = get()) }
    factory<GetCommunityListUseCase> { GetCommunityListUseCase(repository = get()) }

    factory<GetCurrentPhoneNumberUseCase> { GetCurrentPhoneNumberUseCase(repository = get()) }
    factory<SendPinCodeOnPhoneUseCase> { SendPinCodeOnPhoneUseCase(repository = get()) }
}