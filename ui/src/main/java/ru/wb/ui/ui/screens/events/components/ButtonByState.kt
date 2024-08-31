package ru.wb.ui.ui.screens.events.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.button.GradientButton
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ButtonByState(
    state: String,
    countPeople: Int,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {},
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Всего ${countPeople} мест. Если передумаете - отпишитесь",
            style = AppTheme.typography.secondary,
            color = AppTheme.colors.brandColorDefault,
            textAlign = TextAlign.Center,
        )

        GradientButton(
            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
            onClick = onClickButton,
            text = when (state) {
                ButtonState.PRESSED.id -> ButtonState.PRESSED.label
                else -> ButtonState.UNPRESSED.label
            },
        )
    }
}