package ru.wb.ui.ui.screens.events.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.button.PrimaryButton
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ButtonByState(
    state: String,
    countPeople: Int,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {},
) {
    val (textButtonColor, buttonColor, labelText, disable, labelTextColor) = when {
        state == ButtonState.PRESSED.id -> {
            listOf(
                AppTheme.colors.brandColorDefault,
                AppTheme.colors.gradient3,
                "✓ Вы пойдёте",
                false,
                AppTheme.colors.accentSuccess,
            )
        }
        countPeople == 0 && state != ButtonState.PRESSED.id -> {
            listOf(
                AppTheme.colors.neutralColorSecondaryText,
                AppTheme.colors.gradient2,
                "К сожалению, мест не осталось(",
                true,
                AppTheme.colors.brandColorDefault,
            )
        }
        else -> {
            listOf(
                AppTheme.colors.neutralColorBackground,
                AppTheme.colors.gradient1,
                "Всего ${countPeople} мест. Если передумаете - отпишитесь",
                false,
                AppTheme.colors.brandColorDefault
            )
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = HORIZONTAL_PADDING_CONTENT_COMMON.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = labelText as String,
                style = AppTheme.typography.secondary,
                color = labelTextColor as Color,
                textAlign = TextAlign.Center,
            )

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClickButton,
                disabled = disable as Boolean,
                text = when (state) {
                    ButtonState.PRESSED.id -> ButtonState.PRESSED.label
                    else -> ButtonState.UNPRESSED.label
                },
                textColor = textButtonColor as Color,
                gradient = buttonColor as Brush,
            )
        }
    }
}