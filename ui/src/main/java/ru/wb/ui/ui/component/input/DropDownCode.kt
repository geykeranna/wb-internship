package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_ITEM_DROPDOWN
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DropDownCode(
    expanded: Boolean,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    onDismissRequest: () -> Unit,
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit,
    modifier: Modifier = Modifier,
    isActive: Boolean = false,
    isInvalid: Boolean = false,
    onChangeExpanded: () -> Unit = {},
) {
    ContentInDropDownMenuItem(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
            .clickable { onChangeExpanded() }
            .background(
                when {
                    isInvalid -> AppTheme.colors.neutralColorInvalidBackground
                    else -> AppTheme.colors.neutralColorSecondaryBackground
                }
            )
            .padding(CONTENT_PADDING_OF_ITEM_DROPDOWN.dp),
        phoneCountryCode = selectedPhoneCountryCode,
        isActive = isActive,
    )
    DropdownMenu(
        modifier = Modifier.background(AppTheme.colors.neutralColorSecondaryBackground),
        expanded = expanded,
        onDismissRequest = { onDismissRequest() }
    ){
        phoneCountryCodeList.forEach { phoneCountryCode ->
            DropdownMenuItem(
                modifier = Modifier.background(AppTheme.colors.neutralColorSecondaryBackground),
                text = {
                    ContentInDropDownMenuItem(
                        phoneCountryCode = phoneCountryCode,
                        isActive = isActive,
                    )
                },
                onClick = {
                    onSelectedPhoneCountryCode(phoneCountryCode)
                    onDismissRequest()
                }
            )
        }
    }
}