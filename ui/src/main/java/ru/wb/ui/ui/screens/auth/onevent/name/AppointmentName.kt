package ru.wb.ui.ui.screens.auth.onevent.name

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.R
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.name.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.name.AppointmentNameViewModel.Event

@Composable
internal fun AppointmentName(
    idEvent: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    label: String = "",
    title: String = stringResource(id = R.string.label_enter_on_meet),
    viewModel: AppointmentNameViewModel = koinViewModel()
) {
    val inputValue by viewModel.getInput().collectAsStateWithLifecycle()
    val status by viewModel.getValidationFlow().collectAsStateWithLifecycle()

    AppointmentCard(
        modifier = modifier.padding(top = 20.dp, bottom = 28.dp).padding(horizontal = 16.dp),
        eventLabel = label,
        title = title,
        value = inputValue,
        disableEnter = !status,
        onBackClick = { navController.popBackStack(
            route = Screen.EVENT_DETAIL.route + "/$idEvent",
            inclusive = false
        )},
        onEnterClick = {
            viewModel.obtainEvent(Event.OnEnterClick)
            navController.navigate(Screen.APPOINTMENT_PHONE.route + "/$idEvent/$label")
        },
        onChangeValue = { input ->
            viewModel.obtainEvent(Event.OnChangeValue(input))
        },
    )
}