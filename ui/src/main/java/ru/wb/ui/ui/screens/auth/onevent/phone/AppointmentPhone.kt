package ru.wb.ui.ui.screens.auth.onevent.phone

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
import ru.wb.ui.ui.component.navigation.Screen
import ru.wb.ui.ui.screens.auth.onevent.phone.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.phone.AppointmentPhoneViewModel.Event

@Composable
internal fun AppointmentPhone(
    idEvent: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    label: String = "",
    title: String = stringResource(id = R.string.label_enter_on_meet),
    viewModel: AppointmentPhoneViewModel = koinViewModel(parameters = { parametersOf(idEvent) })
) {
    val inputValue by viewModel.getInput().collectAsStateWithLifecycle()
    val countryCodesOptions by viewModel.getCountryCodesOptionsFlow().collectAsStateWithLifecycle()
    val selectedCountryCodes by viewModel.getSelectedCountryPhoneFlow().collectAsStateWithLifecycle()
    val enableEnter by viewModel.getValidationFlow().collectAsStateWithLifecycle()

    AppointmentCard(
        modifier = modifier.padding(top = 20.dp, bottom = 28.dp).padding(horizontal = 16.dp),
        eventLabel = label,
        inputValue = inputValue,
        selectedPhoneCountryCode = selectedCountryCodes,
        phoneCountryCodeList = countryCodesOptions,
        title = title,
        disable = !enableEnter,
        onBackClick = { navController.popBackStack(
            route = Screen.EVENT_DETAIL.route + "/$idEvent",
            inclusive = false
        )},
        onSelectedPhoneCountryCode = { value ->
            viewModel.obtainEvent(Event.OnSelectedPhoneCountryCode(value))
        },
        onEnterClick = {
            navController.navigate(Screen.APPOINTMENT_PIN.route + "/$idEvent/$label")
        },
        onChangeValue = { newValue ->
            viewModel.obtainEvent(Event.OnChangeValue(newValue))
        },
    )
}