package ru.wb.ui.ui.component.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_ITEM_DROPDOWN

@Composable
internal fun InputNumberField(
    phone: String,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    modifier: Modifier = Modifier,
    isInvalid: Boolean = false,
    disable: Boolean = false,
    disableEnter: Boolean = false,
    onChange: (value: String) -> Unit = {},
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_ITEM_DROPDOWN.dp)
    ) {
        DropDownCode(
            modifier = Modifier,
            expanded = expanded,
            selectedPhoneCountryCode = selectedPhoneCountryCode,
            phoneCountryCodeList = phoneCountryCodeList,
            onChangeExpanded = { expanded = !expanded },
            onDismissRequest = { expanded = false },
            isActive = phone.isNotEmpty(),
            isInvalid = isInvalid,
            onSelectedPhoneCountryCode = onSelectedPhoneCountryCode
        )

        InputNumberTextField(
            input = phone,
            isInvalid = isInvalid,
            disableEnter = disableEnter,
            disable = disable,
            selectedPhoneCountryCode = selectedPhoneCountryCode,
            onChange = onChange,
            onEnterClick = onEnterClick
        )
    }
}