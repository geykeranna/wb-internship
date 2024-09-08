package ru.wb.domain.di

import org.koin.dsl.module
import ru.wb.domain.usecases.common.GetChipsInterestUseCase
import ru.wb.domain.usecases.common.GetChipsInterestUseCaseImpl
import ru.wb.domain.usecases.common.GetContentUseCase
import ru.wb.domain.usecases.common.GetContentUseCaseImpl
import ru.wb.domain.usecases.common.GetCountryCodesListUseCase
import ru.wb.domain.usecases.common.GetCountryCodesListUseCaseImpl
import ru.wb.domain.usecases.common.GetSocialMediaListUseCase
import ru.wb.domain.usecases.common.GetSocialMediaListUseCaseImpl
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.domain.usecases.community.GetCommunityDataUseCaseImpl
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.community.GetCommunityListUseCaseImpl
import ru.wb.domain.usecases.community.PostSubscribeOnCommunity
import ru.wb.domain.usecases.community.PostSubscribeOnCommunityImpl
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.event.GetEventDataUseCaseImpl
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.event.GetEventListUseCaseImpl
import ru.wb.domain.usecases.event.PostSubscribeOnEvent
import ru.wb.domain.usecases.event.PostSubscribeOnEventImpl
import ru.wb.domain.usecases.login.CheckAuthStateUseCase
import ru.wb.domain.usecases.login.CheckAuthStateUseCaseImpl
import ru.wb.domain.usecases.login.CheckOTPCodeUseCase
import ru.wb.domain.usecases.login.CheckOTPCodeUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCaseImpl
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCaseImpl
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCaseImpl
import ru.wb.domain.usecases.user.ChangeSubscriptionCommunityStatusUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionCommunityStatusUseCaseImpl
import ru.wb.domain.usecases.user.GetSubscriptionCommunityStatusUseCase
import ru.wb.domain.usecases.user.GetSubscriptionCommunityStatusUseCaseImpl
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCaseImpl
import ru.wb.domain.usecases.user.GetUserListUseCase
import ru.wb.domain.usecases.user.GetUserListUseCaseImpl
import ru.wb.domain.usecases.user.ChangeSubscriptionEventStatusUseCase
import ru.wb.domain.usecases.user.ChangeSubscriptionEventStatusUseCaseImpl
import ru.wb.domain.usecases.user.GetSubscriptionEventStatusUseCase
import ru.wb.domain.usecases.user.GetSubscriptionEventStatusUseCaseImpl
import ru.wb.domain.usecases.user.PostUserDataUseCase
import ru.wb.domain.usecases.user.PostUserDataUseCaseImpl
import ru.wb.domain.usecases.user.PutUserDataUseCase
import ru.wb.domain.usecases.user.PutUserDataUseCaseImpl

val domainModules = module {
    single<GetUserDataUseCase> { GetUserDataUseCaseImpl(get()) }
    single<GetUserListUseCase> { GetUserListUseCaseImpl(get()) }
    single<PostUserDataUseCase> { PostUserDataUseCaseImpl(get()) }
    single<PutUserDataUseCase> { PutUserDataUseCaseImpl(get()) }
    single<ChangeSubscriptionEventStatusUseCase> { ChangeSubscriptionEventStatusUseCaseImpl(get()) }
    single<ChangeSubscriptionCommunityStatusUseCase> { ChangeSubscriptionCommunityStatusUseCaseImpl(get()) }
    single<GetSubscriptionCommunityStatusUseCase> { GetSubscriptionCommunityStatusUseCaseImpl(get()) }
    single<GetSubscriptionEventStatusUseCase> { GetSubscriptionEventStatusUseCaseImpl(get()) }

    single<GetEventDataUseCase> { GetEventDataUseCaseImpl(get()) }
    single<GetEventListUseCase> { GetEventListUseCaseImpl(get()) }
    single<PostSubscribeOnEvent> { PostSubscribeOnEventImpl(get()) }

    single<GetCommunityDataUseCase> { GetCommunityDataUseCaseImpl(get()) }
    single<GetCommunityListUseCase> { GetCommunityListUseCaseImpl(get()) }
    single<PostSubscribeOnCommunity> { PostSubscribeOnCommunityImpl(get()) }

    single<GetCurrentPhoneNumberUseCase> { GetCurrentPhoneNumberUseCaseImpl(get()) }
    single<SendPinCodeOnPhoneUseCase> { SendPinCodeOnPhoneUseCaseImpl(get()) }
    single<GetCurrentUserIDUseCase> { GetCurrentUserIDUseCaseImpl(get()) }
    single<CheckAuthStateUseCase> { CheckAuthStateUseCaseImpl(get()) }
    single<CheckOTPCodeUseCase> { CheckOTPCodeUseCaseImpl(get()) }

    single<GetContentUseCase> { GetContentUseCaseImpl(get()) }
    single<GetSocialMediaListUseCase> { GetSocialMediaListUseCaseImpl(get()) }
    single<GetCountryCodesListUseCase> { GetCountryCodesListUseCaseImpl(get()) }
    single<GetChipsInterestUseCase> { GetChipsInterestUseCaseImpl(get()) }
}