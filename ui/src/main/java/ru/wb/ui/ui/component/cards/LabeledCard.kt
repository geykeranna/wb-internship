package ru.wb.ui.ui.component.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun LabeledCard(
    label: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (label.isNotEmpty()) {
            Text(
                modifier = Modifier,
                text = label,
                style = AppTheme.typography.heading2,
                color = AppTheme.colors.neutralColorFont,
                overflow = TextOverflow.Visible,
            )
        }

        content()
    }
}