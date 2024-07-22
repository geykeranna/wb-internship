package ru.wb.domain.di

import org.koin.dsl.module
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.domain.usecases.community.GetCommunityDataUseCaseImpl
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.community.GetCommunityListUseCaseImpl
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.event.GetEventDataUseCaseImpl
import ru.wb.domain.usecases.event.GetEventListByGroupUseCase
import ru.wb.domain.usecases.event.GetEventListByGroupUseCaseImpl
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.event.GetEventListUseCaseImpl
import ru.wb.domain.usecases.login.CheckAuthStateUseCase
import ru.wb.domain.usecases.login.CheckAuthStateUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCaseImpl
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCaseImpl
import ru.wb.domain.usecases.login.SendPinCodeUseCase
import ru.wb.domain.usecases.login.SendPinCodeUseCaseImpl
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCaseImpl
import ru.wb.domain.usecases.user.GetUserListUseCase
import ru.wb.domain.usecases.user.GetUserListUseCaseImpl
import ru.wb.domain.usecases.user.SetUserDataUseCase
import ru.wb.domain.usecases.user.SetUserDataUseCaseImpl

val domainModules = module {
    single<GetUserDataUseCase> { GetUserDataUseCaseImpl(get()) }
    single<GetUserListUseCase> { GetUserListUseCaseImpl(get()) }
    single<SetUserDataUseCase> { SetUserDataUseCaseImpl(get()) }

    single<GetEventDataUseCase> { GetEventDataUseCaseImpl(get()) }
    single<GetEventListUseCase> { GetEventListUseCaseImpl(get()) }
    single<GetEventListByGroupUseCase> { GetEventListByGroupUseCaseImpl(get()) }

    single<GetCommunityDataUseCase> { GetCommunityDataUseCaseImpl(get()) }
    single<GetCommunityListUseCase> { GetCommunityListUseCaseImpl(get()) }

    single<GetCurrentPhoneNumberUseCase> { GetCurrentPhoneNumberUseCaseImpl(get()) }
    single<SendPinCodeOnPhoneUseCase> { SendPinCodeOnPhoneUseCaseImpl(get()) }
    single<GetCurrentUserIDUseCase> { GetCurrentUserIDUseCaseImpl(get()) }
    single<CheckAuthStateUseCase> { CheckAuthStateUseCaseImpl(get()) }
    single<SendPinCodeUseCase> { SendPinCodeUseCaseImpl(get()) }
}