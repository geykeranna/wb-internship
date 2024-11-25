package ru.wb.ui.ui.screens.auth.onevent.phone.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentEnterPhone
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentTitle

@Composable
internal fun AppointmentContent(
    description: String,
    inputValue: String,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    modifier: Modifier = Modifier,
    title: String  = "",
    isInvalid: Boolean = false,
    disableEnter: Boolean = false,
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
            description = description,
            title = title,
            modifier = Modifier,
            onCloseClick = onBackClick,
        )

        AppointmentEnterPhone(
            modifier = Modifier,
            phone = inputValue,
            isInvalid = isInvalid,
            disableEnter = disableEnter,
            selectedPhoneCountryCode = selectedPhoneCountryCode,
            phoneCountryCodeList = phoneCountryCodeList,
            onChange = onChangeValue,
            onSelectedPhoneCountryCode = onSelectedPhoneCountryCode,
            onEnterClick = onEnterClick,
        )
    }
}