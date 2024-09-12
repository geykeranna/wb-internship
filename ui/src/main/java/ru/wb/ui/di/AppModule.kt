package ru.wb.ui.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.wb.ui.ui.screens.community.community.CommunityViewModel
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreenViewModel
import ru.wb.ui.ui.screens.events.main.MainEventsScreenViewModel
import ru.wb.ui.ui.screens.events.detail.DetailEventScreenViewModel
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreenViewModel
import ru.wb.ui.ui.screens.auth.onevent.AppointmentViewModel
import ru.wb.ui.ui.screens.main.MainViewModel

val appModule = module {
    viewModelOf(::CommunityViewModel)
    viewModelOf(::MainEventsScreenViewModel)
    viewModelOf(::ProfileViewScreenViewModel)
    viewModelOf(::DetailCommunityScreenViewModel)
    viewModelOf(::DetailEventScreenViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::AppointmentViewModel)
}