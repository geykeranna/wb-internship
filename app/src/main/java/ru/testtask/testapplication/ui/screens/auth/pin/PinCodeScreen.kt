package ru.testtask.testapplication.ui.screens.auth.pin

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.component.navigation.Screen
import ru.testtask.testapplication.ui.component.toolbars.TopBar
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_LOGIN_SCREEN
import ru.testtask.testapplication.ui.screens.auth.pin.components.InputPinCard

@Composable
fun PinCodeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: PinCodeScreenViewModel = koinViewModel()
) {
    TopBar(
        modifier = modifier.padding(horizontal = HORIZONTAL_PADDING_TOP_BAR_LOGIN_SCREEN.dp),
        iconLeft = R.drawable.ic_chevron_left,
        onLeftIconClick = {
            when {
                navController.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED -> navController.popBackStack()
            }
        },
    )

    InputPinCard(
        phone = viewModel.getPhoneNumber().collectAsState().value,
        pin = viewModel.getPinValue().collectAsState().value,
        onChange = {pin -> viewModel.onChangePin(pin)},
        onClickPassAgain = { viewModel.sendPinAgain() }
    ){
        if (viewModel.getValidateState()) {
            navController.navigate(Screen.ProfileFirstEdit.route)
        }
    }
}