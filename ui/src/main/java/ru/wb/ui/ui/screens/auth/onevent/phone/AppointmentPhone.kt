package ru.wb.ui.ui.screens.auth.onevent.phone

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
import ru.wb.ui.ui.screens.auth.onevent.phone.components.AppointmentCard
import ru.wb.ui.ui.screens.auth.onevent.phone.AppointmentPhoneViewModel.Event

@Composable
internal fun AppointmentPhone(
    options: String,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: AppointmentPhoneViewModel = koinViewModel(),
) {
    val (title, description) = appointmentGetParamsByOptions(options = options)
    val inputValue by viewModel.getInput().collectAsStateWithLifecycle()
    val countryCodesOptions by viewModel.getCountryCodesOptionsFlow().collectAsStateWithLifecycle()
    val selectedCountryCodes by viewModel.getSelectedCountryPhoneFlow().collectAsStateWithLifecycle()
    val enableEnter by viewModel.getValidationFlow().collectAsStateWithLifecycle()

    AppointmentCard(
        modifier = modifier
            .padding(top = 20.dp, bottom = 28.dp)
            .padding(horizontal = 16.dp),
        description = description,
        inputValue = inputValue,
        selectedPhoneCountryCode = selectedCountryCodes,
        phoneCountryCodeList = countryCodesOptions,
        title = title,
        disable = !enableEnter,
        onBackClick = { navController.popBackStack() },
        onSelectedPhoneCountryCode = { value ->
            viewModel.obtainEvent(Event.OnSelectedPhoneCountryCode(value))
        },
        onEnterClick = {
            navController.navigate(Screen.APPOINTMENT_PIN.route + "/$options")
        },
        onChangeValue = { newValue ->
            viewModel.obtainEvent(Event.OnChangeValue(newValue))
        },
    )
}