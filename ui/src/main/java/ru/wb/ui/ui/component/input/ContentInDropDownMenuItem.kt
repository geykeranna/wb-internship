package ru.wb.ui.ui.component.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_ITEM_DROPDOWN
import ru.wb.ui.ui.component.utils.Constants.SIZE_FLAG_ICON_DROPDOWN_CODE
import ru.wb.ui.ui.component.utils.defaultFlag
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ContentInDropDownMenuItem(
    phoneCountryCode: CountryCodes,
    isActive: Boolean,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_ITEM_DROPDOWN.dp),
    ) {
        Image(
            modifier = Modifier
                .size(SIZE_FLAG_ICON_DROPDOWN_CODE.dp)
                .clip(RoundedCornerShape(4.dp)),
            painter = painterResource(defaultFlag.getOrElse(phoneCountryCode.flagIcon) {
                R.drawable.empty_flag
            }),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = phoneCountryCode.countryCode,
            style = AppTheme.typography.regular,
            color = if (isActive) AppTheme.colors.neutralColorFont else AppTheme.colors.neutralColorDisabled
        )
    }
}