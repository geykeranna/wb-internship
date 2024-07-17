package ru.testtask.testapplication.ui.screens.profile.edit

import androidx.lifecycle.ViewModel
import ru.testtask.testapplication.domain.usecases.user.GetUserDataUseCase

class ProfileEditScreenViewModel(
    private val getUserData: GetUserDataUseCase
): ViewModel() {
}