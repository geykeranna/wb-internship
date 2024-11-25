package ru.wb.ui.ui.screens.auth.onevent.pin

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.wb.ui.ui.base.BaseScreen
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.components.appointmentGetParamsByOptions
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentScreenTitle
import ru.wb.ui.ui.screens.auth.onevent.pin.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.pin.AppointmentPinViewModel.Event

@Composable
internal fun AppointmentPin(
    options: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AppointmentPinViewModel = koinViewModel()
) {
    val (title, description, id) = appointmentGetParamsByOptions(options)
    val inputValue by viewModel.getInputDataFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val userStatus by viewModel.getUserStatusFlow().collectAsStateWithLifecycle()
    val validateStatus by viewModel.getValidateStatus().collectAsStateWithLifecycle()
    val textButtonData by viewModel.getTextButtonFlow().collectAsStateWithLifecycle()
    val contextState by viewModel.getContextFlow().collectAsStateWithLifecycle()

    BaseScreen(
        modifier = modifier.fillMaxSize(),
        state = state,
    ){
        AppointmentCard(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 28.dp)
                .padding(horizontal = 16.dp),
            description = description,
            title = title,
            inputValue = inputValue,
            invalidPin = validateStatus == false,
            disableEnter = !contextState.isActive,
            onBackClick = { navController.popBackStack() },
            contextString = contextState.contextString,
            textButtonValue = textButtonData.first() as String?,
            disableTextButtonEnter = textButtonData[1] as Boolean,
            onTextButtonClick = { viewModel.obtainEvent(Event.OnSendNewCode) },
            onEnterClick = {
                when {
                    validateStatus == true && title == AppointmentScreenTitle.EVENT.title -> {
                        navController.navigate(Screen.SUBMIT_EVENT.route + "/$description")
                    }
                    validateStatus == true && title == AppointmentScreenTitle.USER.title
                            && userStatus -> {
                        navController.navigate(Screen.EDIT_USER.route)
                    }
                    validateStatus == true && title == AppointmentScreenTitle.USER.title -> {
                        navController.navigate(Screen.EDIT_USER.route)
                    }
                    validateStatus == true -> {
                        navController.popBackStack()
                    }
                    else -> viewModel.obtainEvent(Event.OnEnterClick(group = title, id = id))
                }
            },
            onChangeValue = { newValue ->
                viewModel.obtainEvent(Event.OnChangeValue(newValue))
            },
        )
    }
}