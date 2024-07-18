package ru.testtask.testapplication.di.modules

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.testtask.testapplication.ui.screens.auth.phone.PhoneScreenViewModel
import ru.testtask.testapplication.ui.screens.auth.pin.PinCodeScreenViewModel
import ru.testtask.testapplication.ui.screens.community.community.CommunityViewModel
import ru.testtask.testapplication.ui.screens.community.detail.DetailCommunityScreenViewModel
import ru.testtask.testapplication.ui.screens.events.active.ActiveEventsScreenViewModel
import ru.testtask.testapplication.ui.screens.events.detail.DetailEventScreenViewModel
import ru.testtask.testapplication.ui.screens.events.myevents.MyEventScreenViewModel
import ru.testtask.testapplication.ui.screens.profile.edit.ProfileEditScreenViewModel
import ru.testtask.testapplication.ui.screens.profile.view.ProfileViewScreenViewModel

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
}