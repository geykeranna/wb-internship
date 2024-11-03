package ru.wb.ui.ui.screens.auth.onevent.phone.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.R
import ru.wb.ui.ui.screens.auth.onevent.components.AppointmentBottomButtons

@Composable
internal fun AppointmentCard(
    eventLabel: String,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    inputValue: String,
    modifier: Modifier = Modifier,
    title: String  = "",
    disable: Boolean = false,
    onBackClick: () -> Unit = {},
    onEnterClick: () -> Unit = {},
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit = {},
    onChangeValue: (input: String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        item {
            AppointmentContent(
                modifier = Modifier,
                eventLabel = eventLabel,
                inputValue = inputValue,
                selectedPhoneCountryCode = selectedPhoneCountryCode,
                phoneCountryCodeList = phoneCountryCodeList,
                title = title,
                disableEnter = disable,
                onBackClick = onBackClick,
                onSelectedPhoneCountryCode = onSelectedPhoneCountryCode,
                onChangeValue = onChangeValue,
                onEnterClick = onEnterClick,
            )
        }

        item {
            AppointmentBottomButtons(
                modifier = Modifier,
                primaryButtonText = stringResource(id = R.string.text_get_code),
                disableButton = disable,
                onEnterClick = onEnterClick,
            )
        }
    }
}