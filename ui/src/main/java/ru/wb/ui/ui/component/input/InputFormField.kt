package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_INPUT_FIELD
import ru.wb.ui.ui.component.utils.Constants.ICON_SIZE_IN_INPUT_FIELD
import ru.wb.ui.ui.component.utils.focusedBorder
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun InputFormField(
    value: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    disable: Boolean = false,
    disableEnter: Boolean = false,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    fontStyle: TextStyle = AppTheme.typography.regular,
    minLines: Int = 1,
    onEnterClick: () -> Unit = {},
    iconLeft: Painter? = null,
    iconRight: Painter? = null,
    onClickRightIcon: (() -> Unit?)? = null,
    onClickLeftIcon: (() -> Unit)? = null,
    onChangeValue: (text: String) -> Unit = {},
){
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.freeFocus()
    }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val hintColor = when {
        value.isEmpty() -> {
            AppTheme.colors.neutralColorDisabled
        }
        else -> {
            Color.Transparent
        }
    }
    val contentColor = when {
        value.isEmpty() && !isFocused -> {
            AppTheme.colors.neutralColorDisabled
        }
        else -> {
            AppTheme.colors.neutralColorFont
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .focusable(interactionSource = interactionSource)
            .hoverable(interactionSource = interactionSource)
            .clip(RoundedCornerShape(CORNER_RADIUS_OF_INPUT_FIELD.dp))
            .background(AppTheme.colors.neutralColorSecondaryBackground)
            .focusedBorder(isFocused && value.isEmpty(), AppTheme.colors.neutralColorDivider)
            .padding(vertical = 16.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        iconLeft?.let {
            Icon(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_OF_INPUT_FIELD.dp))
                    .clickable { onClickLeftIcon?.let { onClickLeftIcon() } }
                    .size(ICON_SIZE_IN_INPUT_FIELD.dp),
                painter = it,
                tint = contentColor,
                contentDescription = ""
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.90f)
                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = placeholder,
                style = fontStyle,
                color = hintColor,
            )

            BasicTextField(
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .fillMaxWidth(),
                enabled = !disable,
                value = value,
                singleLine = minLines == 1,
                minLines = minLines,
                cursorBrush = SolidColor(AppTheme.colors.neutralColorFont),
                textStyle = fontStyle.copy(color = AppTheme.colors.neutralColorFont),
                interactionSource = interactionSource,
                onValueChange = onChangeValue,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = { if(disableEnter) Unit else onEnterClick() })
            )
        }
        iconRight?.let {
            Icon(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_OF_INPUT_FIELD.dp))
                    .clickable { onClickRightIcon?.let { onClickRightIcon() } }
                    .size(ICON_SIZE_IN_INPUT_FIELD.dp),
                painter = it,
                tint = contentColor,
                contentDescription = ""
            )
        }
    }
}