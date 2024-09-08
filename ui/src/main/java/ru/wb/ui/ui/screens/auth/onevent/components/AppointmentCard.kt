package ru.wb.ui.ui.screens.auth.onevent.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.wb.domain.model.CountryCodes

@Composable
internal fun AppointmentCard(
    eventLabel: String,
    formData: AppointmentFormData,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    modifier: Modifier = Modifier,
    title: String  = "",
    description: String = "",
    textButtonValue: String? = null,
    isInvalid: Boolean = false,
    disable: Boolean = false,
    active: Boolean = false,
    screenState: AppointmentScreenState = AppointmentScreenState.ENTER_NAME,
    onBackClick: () -> Unit = {},
    onEnterClick: () -> Unit = {},
    onTextButtonClick: () -> Unit = {},
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
                formData = formData,
                selectedPhoneCountryCode = selectedPhoneCountryCode,
                phoneCountryCodeList = phoneCountryCodeList,
                title = title,
                description = description,
                isInvalid = isInvalid,
                disable = disable,
                screenState = screenState,
                onBackClick = onBackClick,
                onSelectedPhoneCountryCode = onSelectedPhoneCountryCode,
                onChangeValue = onChangeValue,
                onEnterClick = onEnterClick,
            )
        }
        item {
            AppointmentButtonsByState(
                modifier = Modifier,
                textButtonValue = textButtonValue,
                disable = disable,
                active = active,
                screenState = screenState,
                onEnterClick = onEnterClick,
                onClick = onTextButtonClick
            )
        }
    }
}