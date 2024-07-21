package ru.wb.testapplication.modules

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.wb.domain.usecases.community.GetCommunityDataUseCase
import ru.wb.domain.usecases.community.GetCommunityListUseCase
import ru.wb.domain.usecases.event.GetEventDataUseCase
import ru.wb.domain.usecases.event.GetEventListByGroupUseCase
import ru.wb.domain.usecases.event.GetEventListUseCase
import ru.wb.domain.usecases.login.CheckAuthStateUseCase
import ru.wb.domain.usecases.login.GetCurrentPhoneNumberUseCase
import ru.wb.domain.usecases.login.GetCurrentUserIDUseCase
import ru.wb.domain.usecases.login.SendPinCodeOnPhoneUseCase
import ru.wb.domain.usecases.login.SendPinCodeUseCase
import ru.wb.domain.usecases.user.GetUserDataUseCase
import ru.wb.domain.usecases.user.GetUserListUseCase
import ru.wb.domain.usecases.user.SetUserDataUseCase

val domainModules = module {
    factoryOf(::GetUserDataUseCase)
    factoryOf(::GetUserListUseCase)
    factoryOf(::SetUserDataUseCase)

    factoryOf(::GetEventDataUseCase)
    factoryOf(::GetEventListUseCase)
    factoryOf(::GetEventListByGroupUseCase)

    factoryOf(::GetCommunityDataUseCase)
    factoryOf(::GetCommunityListUseCase)

    factoryOf(::GetCurrentPhoneNumberUseCase)
    factoryOf(::SendPinCodeOnPhoneUseCase)
    factoryOf(::GetCurrentUserIDUseCase)
    factoryOf(::CheckAuthStateUseCase)
    factoryOf(::SendPinCodeUseCase)
}