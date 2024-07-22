package ru.wb.testapplication.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.wb.testapplication.ui.screens.auth.phone.PhoneScreenViewModel
import ru.wb.testapplication.ui.screens.auth.pin.PinCodeScreenViewModel
import ru.wb.testapplication.ui.screens.community.community.CommunityViewModel
import ru.wb.testapplication.ui.screens.community.detail.DetailCommunityScreenViewModel
import ru.wb.testapplication.ui.screens.events.active.ActiveEventsScreenViewModel
import ru.wb.testapplication.ui.screens.events.detail.DetailEventScreenViewModel
import ru.wb.testapplication.ui.screens.events.myevents.MyEventScreenViewModel
import ru.wb.testapplication.ui.screens.profile.edit.ProfileEditScreenViewModel
import ru.wb.testapplication.ui.screens.profile.view.ProfileViewScreenViewModel
import ru.wb.testapplication.ui.screens.main.MainViewModel

val appModule = module {
    viewModelOf(::PhoneScreenViewModel)
    viewModelOf(::PinCodeScreenViewModel)
    viewModelOf(::CommunityViewModel)
    viewModelOf(::ActiveEventsScreenViewModel)
    viewModelOf(::MyEventScreenViewModel)
    viewModelOf(::ProfileEditScreenViewModel)
    viewModelOf(::ProfileViewScreenViewModel)
    viewModelOf(::DetailCommunityScreenViewModel)
    viewModelOf(::DetailEventScreenViewModel)
    viewModelOf(::MainViewModel)
}