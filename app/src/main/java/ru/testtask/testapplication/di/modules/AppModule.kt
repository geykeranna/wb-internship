package ru.testtask.testapplication.di.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.testtask.testapplication.ui.screens.auth.phone.PhoneScreenViewModel
import ru.testtask.testapplication.ui.screens.auth.pin.PinCodeScreenViewModel
import ru.testtask.testapplication.ui.screens.community.community.CommunityViewModel
import ru.testtask.testapplication.ui.screens.events.active.ActiveEventsScreenViewModel
import ru.testtask.testapplication.ui.screens.events.detail.DetailEventScreenViewModel
import ru.testtask.testapplication.ui.screens.events.myevents.MyEventScreenViewModel
import ru.testtask.testapplication.ui.screens.profile.edit.ProfileEditScreenViewModel
import ru.testtask.testapplication.ui.screens.profile.view.ProfileViewScreenViewModel

val appModule = module {
    viewModel {
        PhoneScreenViewModel(
            sendPin = get()
        )
    }

    viewModel {
        PinCodeScreenViewModel(
            getPhone = get(),
            sendPin = get()
        )
    }

    viewModel {
        CommunityViewModel(
            getDataList = get()
        )
    }

    viewModel {
        DetailEventScreenViewModel(
            getData = get()
        )
    }

    viewModel {
        ActiveEventsScreenViewModel(
            getEvents = get()
        )
    }

    viewModel {
        DetailEventScreenViewModel(
            getData = get()
        )
    }

    viewModel {
        MyEventScreenViewModel(
            getEvents = get()
        )
    }

    viewModel {
        ProfileEditScreenViewModel(
            getUserData = get()
        )
    }

    viewModel {
        ProfileViewScreenViewModel(
            getUserData = get()
        )
    }
}