package ru.wb.ui.ui.component.switch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun HorizontalSwitchWithLabel(
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

        GradientSwitch(
            modifier = Modifier.size(width = 48.dp, height = 24.dp),
            checked = checked,
            onCheckedChange = { checked -> onCheckChange(checked) },
        )
    }
}