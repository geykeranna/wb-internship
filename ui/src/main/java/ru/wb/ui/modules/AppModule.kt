package ru.wb.ui.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.wb.ui.ui.screens.auth.phone.PhoneScreenViewModel
import ru.wb.ui.ui.screens.auth.pin.PinCodeScreenViewModel
import ru.wb.ui.ui.screens.community.community.CommunityViewModel
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreenViewModel
import ru.wb.ui.ui.screens.events.active.ActiveEventsScreenViewModel
import ru.wb.ui.ui.screens.events.detail.DetailEventScreenViewModel
import ru.wb.ui.ui.screens.events.myevents.MyEventScreenViewModel
import ru.wb.ui.ui.screens.profile.edit.ProfileEditScreenViewModel
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreenViewModel
import ru.wb.ui.ui.screens.main.MainViewModel

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