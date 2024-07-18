package ru.testtask.testapplication.ui.screens.profile.view

import androidx.lifecycle.ViewModel
import ru.testtask.testapplication.domain.usecases.user.GetUserDataUseCase

class ProfileViewScreenViewModel(
    private val getUserData: GetUserDataUseCase
): ViewModel() {
}