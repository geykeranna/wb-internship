package ru.wb.ui.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import ru.wb.ui.ui.screens.community.community.CommunityViewModel
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreenViewModel
import ru.wb.ui.ui.screens.events.main.MainEventsScreenViewModel
import ru.wb.ui.ui.screens.events.detail.DetailEventScreenViewModel
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreenViewModel
import ru.wb.ui.ui.screens.auth.onevent.name.AppointmentNameViewModel
import ru.wb.ui.ui.screens.auth.onevent.pin.AppointmentPinViewModel
import ru.wb.ui.ui.screens.auth.onevent.phone.AppointmentPhoneViewModel
import ru.wb.ui.ui.screens.main.MainViewModel
import ru.wb.ui.ui.screens.profile.delete.DeleteProfileViewScreenViewModel
import ru.wb.ui.ui.screens.startscreens.interests.InterestsScreenViewModel

val appModule = module {
    viewModelOf(::CommunityViewModel)
    viewModelOf(::MainEventsScreenViewModel)
    viewModelOf(::ProfileViewScreenViewModel)
    viewModelOf(::DetailCommunityScreenViewModel)
    viewModelOf(::DetailEventScreenViewModel)
    viewModelOf(::MainViewModel)
    viewModelOf(::AppointmentPinViewModel)
    viewModelOf(::AppointmentNameViewModel)
    viewModelOf(::AppointmentPhoneViewModel)
    viewModelOf(::InterestsScreenViewModel)
    viewModelOf(::DeleteProfileViewScreenViewModel)
}