package ru.wb.domain.di

import org.koin.dsl.module
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.domain.usecases.community.GetCommunityDataUseCaseImpl
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.community.GetCommunityListUseCaseImpl
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.event.GetEventDataUseCaseImpl
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.event.GetEventListUseCaseImpl
import ru.wb.domain.usecases.login.CheckAuthStateUseCase
import ru.wb.domain.usecases.login.CheckAuthStateUseCaseImpl
import ru.wb.domain.usecases.login.CheckPinCodeUseCase
import ru.wb.domain.usecases.login.CheckPinCodeUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCaseImpl
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCaseImpl
import ru.wb.domain.usecases.user.ChangeSubscriptionStatusUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionStatusUseCaseImpl
import ru.wb.domain.usecases.user.GetSubscriptionStatusUseCase
import ru.wb.domain.usecases.user.GetSubscriptionStatusUseCaseImpl
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCaseImpl
import ru.wb.domain.usecases.user.GetUserListUseCase
import ru.wb.domain.usecases.user.GetUserListUseCaseImpl
import ru.wb.domain.usecases.user.HandleGoingEventUseCase
import ru.wb.domain.usecases.user.HandleGoingEventImpl
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCaseImpl
import ru.wb.domain.usecases.user.PutUserDataUseCase
import ru.wb.domain.usecases.user.PutUserDataUseCaseImpl

val domainModules = module {
    single<GetUserDataUseCase> { GetUserDataUseCaseImpl(get()) }
    single<GetUserListUseCase> { GetUserListUseCaseImpl(get()) }
    single<PostUserDataUseCase> { PostUserDataUseCaseImpl(get()) }
    single<PutUserDataUseCase> { PutUserDataUseCaseImpl(get()) }
    single<HandleGoingEventUseCase> { HandleGoingEventImpl(get()) }
    single<ChangeSubscriptionStatusUseCase> { ChangeSubscriptionStatusUseCaseImpl(get()) }
    single<GetSubscriptionStatusUseCase> { GetSubscriptionStatusUseCaseImpl(get()) }

    single<GetEventDataUseCase> { GetEventDataUseCaseImpl(get()) }
    single<GetEventListUseCase> { GetEventListUseCaseImpl(get()) }

    single<GetCommunityDataUseCase> { GetCommunityDataUseCaseImpl(get()) }
    single<GetCommunityListUseCase> { GetCommunityListUseCaseImpl(get()) }

    single<GetCurrentPhoneNumberUseCase> { GetCurrentPhoneNumberUseCaseImpl(get()) }
    single<SendPinCodeOnPhoneUseCase> { SendPinCodeOnPhoneUseCaseImpl(get()) }
    single<GetCurrentUserIDUseCase> { GetCurrentUserIDUseCaseImpl(get()) }
    single<CheckAuthStateUseCase> { CheckAuthStateUseCaseImpl(get()) }
    single<CheckPinCodeUseCase> { CheckPinCodeUseCaseImpl(get()) }
}