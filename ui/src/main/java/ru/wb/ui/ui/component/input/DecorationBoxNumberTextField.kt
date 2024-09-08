package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DecorationBoxNumberTextField(
    value: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    innerTextField: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
            .fillMaxWidth()
            .background(AppTheme.colors.neutralColorSecondaryBackground)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (value.isEmpty()){
            Text(
                text = placeholder,
                style = AppTheme.typography.bodyText1,
                color = AppTheme.colors.neutralColorDisabled
            )
        }
        innerTextField()
    }
}