package ru.wb.ui.ui.screens.auth.onevent.pin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import ru.wb.ui.R
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.pin.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.pin.AppointmentPinViewModel.Event

@Composable
internal fun AppointmentPin(
    idEvent: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    label: String = "",
    title: String = stringResource(id = R.string.label_enter_on_meet),
    viewModel: AppointmentPinViewModel = koinViewModel(parameters = { parametersOf(idEvent) })
) {
    val userId by viewModel.getUserIdFlow().collectAsStateWithLifecycle()
    val inputValue by viewModel.getInputDataFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val validateStatus by viewModel.getValidateStatus().collectAsStateWithLifecycle()
    val textButtonData by viewModel.getTextButtonFlow().collectAsStateWithLifecycle()
    val contextState by viewModel.getContextFlow().collectAsStateWithLifecycle()

    BaseScreen(
        modifier = modifier.fillMaxSize(),
        state = state,
    ){
        AppointmentCard(
            modifier = Modifier.padding(top = 20.dp, bottom = 28.dp).padding(horizontal = 16.dp),
            eventLabel = label,
            title = title,
            inputValue = inputValue,
            invalidPin = validateStatus == false,
            disableEnter = !contextState.isActive,
            onBackClick = { navController.popBackStack(
                route = Screen.EVENT_DETAIL.route + "/$idEvent",
                inclusive = false
            )},
            contextString = contextState.contextString,
            textButtonValue = textButtonData.first() as String?,
            disableTextButtonEnter = textButtonData[1] as Boolean,
            onTextButtonClick = { viewModel.obtainEvent(Event.OnSendNewCode) },
            onEnterClick = {
                when {
                    validateStatus == true -> navController.navigate(Screen.SUBMIT_EVENT.route + "/$label/$userId")
                    else -> viewModel.obtainEvent(Event.OnEnterClick)
                }
            },
            onChangeValue = { newValue ->
                viewModel.obtainEvent(Event.OnChangeValue(newValue))
            },
        )
    }
}