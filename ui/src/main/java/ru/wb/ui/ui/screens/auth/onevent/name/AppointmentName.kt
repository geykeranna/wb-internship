package ru.wb.ui.ui.screens.auth.onevent.name

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.components.appointmentGetParamsByOptions
import ru.wb.ui.ui.screens.auth.onevent.name.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.name.AppointmentNameViewModel.Event

@Composable
internal fun AppointmentName(
    options: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AppointmentNameViewModel = koinViewModel()
) {
    val (title, description) = appointmentGetParamsByOptions(options = options)
    val inputValue by viewModel.getInput().collectAsStateWithLifecycle()
    val status by viewModel.getValidationFlow().collectAsStateWithLifecycle()

    AppointmentCard(
        modifier = modifier.padding(top = 20.dp, bottom = 28.dp).padding(horizontal = 16.dp),
        description = description,
        title = title,
        value = inputValue,
        disableEnter = !status,
        onBackClick = { navController.popBackStack() },
        onEnterClick = {
            viewModel.obtainEvent(Event.OnEnterClick)
            navController.navigate(Screen.SUBMIT_EVENT.route + "/$description")
        },
        onChangeValue = { input ->
            viewModel.obtainEvent(Event.OnChangeValue(input))
        },
    )
}