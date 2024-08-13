package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_ITEM_DROPDOWN
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.ui.ui.component.utils.Constants.SIZE_FLAG_ICON_DROPDOWN_CODE
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DropDownCode(
    expanded: Boolean,
    selectedPhoneCountryCode: CountryCodes,
    phoneCountryCodeList: List<CountryCodes>,
    onDismissRequest: () -> Unit,
    onSelectedPhoneCountryCode: (value: CountryCodes) -> Unit,
    modifier: Modifier = Modifier,
    stateColor: Boolean = false,
    onChangeExpanded: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
            .clickable { onChangeExpanded() }
            .background(AppTheme.colors.neutralColorSecondaryBackground)
            .padding(CONTENT_PADDING_OF_ITEM_DROPDOWN.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_ITEM_DROPDOWN.dp)
    ) {
        AsyncImage(
            modifier = Modifier.size(SIZE_FLAG_ICON_DROPDOWN_CODE.dp),
            model = selectedPhoneCountryCode.flagIcon,
            contentDescription = null,
        )
        Text(
            text = selectedPhoneCountryCode.countryCode,
            style = AppTheme.typography.bodyText1,
            color = if (stateColor) AppTheme.colors.neutralColorFont else AppTheme.colors.neutralColorDisabled
        )
    }
    DropdownMenu(
        modifier = Modifier
            .background(AppTheme.colors.neutralColorSecondaryBackground),
        expanded = expanded,
        onDismissRequest = { onDismissRequest() }
    ){
        phoneCountryCodeList.forEach { phoneCountryCode ->
            DropdownMenuItem(
                modifier = Modifier
                    .background(AppTheme.colors.neutralColorSecondaryBackground),
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            CONTENT_PADDING_OF_ITEM_DROPDOWN.dp),
                    ) {
                        AsyncImage(
                            modifier = Modifier.size(SIZE_FLAG_ICON_DROPDOWN_CODE.dp),
                            model = phoneCountryCode.flagIcon,
                            contentDescription = null,
                        )
                        Text(
                            text = phoneCountryCode.countryCode,
                            style = AppTheme.typography.bodyText1,
                            color = if (stateColor) AppTheme.colors.neutralColorFont else AppTheme.colors.neutralColorDisabled
                        )
                    }
                },
                onClick = {
                    onSelectedPhoneCountryCode(phoneCountryCode)
                    onDismissRequest()
                }
            )
        }
    }
}