package ru.wb.ui.ui.screens.auth.onevent

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
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentScreenState

@Composable
internal fun Appointment(
    idEvent: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    label: String = "",
    title: String = stringResource(id = R.string.label_enter_on_meet),
    viewModel: AppointmentViewModel = koinViewModel(parameters = { parametersOf(idEvent) })
) {
    val screenState by viewModel.getScreenStateFlow().collectAsStateWithLifecycle()
    val formData by viewModel.getFormDataFlow().collectAsStateWithLifecycle()
    val isSuccessfulRegistration by viewModel.getSuccessfulRegistrationStatusFlow().collectAsStateWithLifecycle()
    val countryCodesOptions by viewModel.getCountryCodesOptionsFlow().collectAsStateWithLifecycle()
    val selectedCountryCodes by viewModel.getSelectedCountryPhoneFlow().collectAsStateWithLifecycle()
    val state by viewModel.getStateFlow().collectAsStateWithLifecycle()
    val validateStatus by viewModel.getValidateStatus().collectAsStateWithLifecycle()
    val textButtonData by viewModel.getTextButtonFlow().collectAsStateWithLifecycle()
    val enterButtonStatusEnable by viewModel.getValidationFlow().collectAsStateWithLifecycle()
    val contextString by viewModel.getContextStringFlow().collectAsStateWithLifecycle()

    BaseScreen(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 28.dp)
            .padding(horizontal = 16.dp),
        state = state,
    ){
        AppointmentCard(
            modifier = Modifier,
            eventLabel = label,
            formData = formData,
            selectedPhoneCountryCode = selectedCountryCodes,
            phoneCountryCodeList = countryCodesOptions,
            title = title,
            textButtonValue = textButtonData.first() as String?,
            active = textButtonData[1] as Boolean,
            description = contextString,
            isInvalid = validateStatus == false,
            screenState = screenState,
            disable = !enterButtonStatusEnable,
            onBackClick = { navController.popBackStack() },
            onSelectedPhoneCountryCode = { value ->
                viewModel.obtainEvent(AppointmentViewModel.Event.OnSelectedPhoneCountryCode(value))
            },
            onChangeValue = { newValue ->
                viewModel.obtainEvent(AppointmentViewModel.Event.OnChangeValue(newValue))
            },
            onTextButtonClick = {
                viewModel.obtainEvent(AppointmentViewModel.Event.OnSendNewCode)
            },
            onEnterClick = {
                when {
                    screenState == AppointmentScreenState.ENTER_PIN && isSuccessfulRegistration -> {
                        navController.navigate(Screen.EVENT_DETAIL.route + "/$idEvent")
                    }
                    else -> {
                        viewModel.obtainEvent(AppointmentViewModel.Event.OnEnterClick)
                    }
                }
            },
        )
    }
}