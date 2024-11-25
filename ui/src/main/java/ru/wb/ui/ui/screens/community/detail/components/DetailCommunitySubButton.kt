package ru.wb.ui.ui.screens.community.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.button.PrimaryButton
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun DetailCommunitySubButton (
    state: ButtonsStateSub,
    modifier: Modifier = Modifier,
    onClickButton: () -> Unit = {},
) {
    val (textColor, buttonColor) = when (state) {
        ButtonsStateSub.PRESSED -> listOf(
            AppTheme.colors.brandColorDefault,
            AppTheme.colors.gradient3
        )
        else -> listOf(
            AppTheme.colors.neutralColorBackground,
            AppTheme.colors.gradient1
        )
    }
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PrimaryButton (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClick = onClickButton,
            text = state.label,
            textColor = textColor as Color,
            gradient = buttonColor as Brush,
        )
        when(state) {
            ButtonsStateSub.PRESSED -> {}
            else -> {
                Text(
                    text = stringResource(id = R.string.text_for_sub_community),
                    style = AppTheme.typography.heading3,
                    color = AppTheme.colors.brandColorDefault,
                )
            }
        }
    }
}