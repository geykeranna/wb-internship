package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes

@Composable
internal fun AppointmentContent(
    eventLabel: String,
    formData: AppointmentFormData,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    modifier: Modifier = Modifier,
    title: String  = "",
    description: String = "",
    isInvalid: Boolean = false,
    disable: Boolean = false,
    screenState: AppointmentScreenState = AppointmentScreenState.ENTER_NAME,
    onBackClick: () -> Unit = {},
    onEnterClick: () -> Unit = {},
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        AppointmentTitle(
            eventLabel = eventLabel,
            title = title,
            modifier = Modifier,
            onCloseClick = onBackClick,
        )

        when (screenState) {
            AppointmentScreenState.ENTER_NAME -> {
                AppointmentEnterName(
                    name = formData.name,
                    disableEnter = disable,
                    onChangeValue = onChangeValue,
                    onEnterClick = onEnterClick,
                )
            }
            AppointmentScreenState.ENTER_PHONE -> {
                AppointmentEnterPhone(
                    modifier = Modifier,
                    phone = formData.phone,
                    isInvalid = isInvalid,
                    disableEnter = disable,
                    selectedPhoneCountryCode = selectedPhoneCountryCode,
                    phoneCountryCodeList = phoneCountryCodeList,
                    onChange = onChangeValue,
                    onSelectedPhoneCountryCode = onSelectedPhoneCountryCode,
                    onEnterClick = onEnterClick,
                )
            }
            AppointmentScreenState.ENTER_PIN -> {
                AppointmentEnterPin(
                    modifier = Modifier,
                    pin = formData.pin,
                    context = description,
                    isInvalid = isInvalid,
                    disableEnter = disable,
                    onChangeValue = onChangeValue,
                    onEnterClick = onEnterClick,
                )
            }
        }
    }
}