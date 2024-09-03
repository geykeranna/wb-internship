package ru.wb.ui.ui.component.checkbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun HorizontalCheckBox(
    label: String,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    color: Color = AppTheme.colors.brandColorDefault,
    onCheckChange: (checked: Boolean) -> Unit = {},
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = color,
            style = AppTheme.typography.primary
        )

        Switch(
            checked = checked,
            onCheckedChange = { checked -> onCheckChange(checked) },
            thumbContent = if (checked) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        modifier = Modifier.size(SwitchDefaults.IconSize),
                        tint = color
                    )
                }
            } else {
                null
            },
        )
    }
}