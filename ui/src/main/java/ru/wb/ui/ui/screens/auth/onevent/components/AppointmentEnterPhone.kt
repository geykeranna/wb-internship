package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.component.input.InputNumberField

@Composable
internal fun AppointmentEnterPhone(
    phone: String,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    modifier: Modifier = Modifier,
    isInvalid: Boolean = false,
    disable: Boolean = false,
    disableEnter: Boolean = false,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit = {}
){
    InputNumberField(
        modifier = modifier,
        selectedPhoneCountryCode = selectedPhoneCountryCode,
        phone = phone,
        isInvalid = isInvalid,
        disable = disable,
        disableEnter = disableEnter,
        phoneCountryCodeList = phoneCountryCodeList,
        onChange = onChange,
        onEnterClick = onEnterClick,
        onSelectedPhoneCountryCode = onSelectedPhoneCountryCode,
    )
}