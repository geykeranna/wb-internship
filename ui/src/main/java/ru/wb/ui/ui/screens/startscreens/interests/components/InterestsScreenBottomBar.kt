package ru.wb.ui.ui.screens.startscreens.interests.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.button.GradientButton
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun InterestsScreenBottomBar(
    disabled: Boolean,
    modifier: Modifier = Modifier,
    isWithCancelButton: Boolean = true,
    onTextClick: () -> Unit = {},
    onButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        GradientButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.label_button_save),
            disabled = disabled,
            onClick = onButtonClick,
        )
        if(isWithCancelButton) {
            Text(
                modifier = Modifier.fillMaxWidth().noRippleClickable { onTextClick() },
                text = stringResource(id = R.string.text_tell_later),
                color = AppTheme.colors.neutralColorSecondaryFont,
                style = AppTheme.typography.primary,
                textAlign = TextAlign.Center,
            )
        }
    }
}