package ru.wb.testapplication.ui.screens.auth.pin

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.testapplication.R
import ru.wb.testapplication.ui.component.navigation.Screen
import ru.wb.testapplication.ui.component.toolbars.TopBar
import ru.wb.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TOP_BAR_LOGIN_SCREEN
import ru.wb.testapplication.ui.screens.auth.pin.components.InputPinCard

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
        phone = viewModel.getPhoneNumber().collectAsStateWithLifecycle().value,
        pin = viewModel.getPinValue().collectAsState().value,
        onChange = {pin -> viewModel.onChangePin(pin)},
        onClickPassAgain = { viewModel.sendPinAgain() }
    ){
        if (viewModel.getValidateState()) {
            navController.navigate(Screen.ProfileFirstEdit.route)
        }
    }
}