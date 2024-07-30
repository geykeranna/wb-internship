package ru.wb.ui.ui.screens.auth.pin

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_LOGIN_SCREEN
import ru.wb.ui.ui.screens.auth.pin.components.InputPinCard
import ru.wb.ui.R

@Composable
internal fun PinCodeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PinCodeScreenViewModel = koinViewModel()
) {
    val phone by viewModel.getPhoneNumberFlow().collectAsStateWithLifecycle()
    val pinCode by viewModel.getPinValueFlow().collectAsStateWithLifecycle()

    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_LOGIN_SCREEN.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = { navController.popBackStack() },
    )

    InputPinCard(
        phone = phone,
        pin = pinCode,
        onChange = {pin -> viewModel.obtainEvent(PinCodeScreenViewModel.Event.OnInputPin(pin))},
        onClickPassAgain = { viewModel.obtainEvent(PinCodeScreenViewModel.Event.OnSendAgain) }
    ){
        if (viewModel.getValidateState()) {
            navController.navigate(Screen.PROFILE_FIRST_EDIT.route)
        }
    }
}