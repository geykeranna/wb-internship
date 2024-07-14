package ru.testtask.testapplication.ui.component.input

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import ru.testtask.testapplication.ui.component.utils.Constants.CORNER_RADIUS_OF_INPUT_FIELD
import ru.testtask.testapplication.ui.component.utils.Constants.FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD
import ru.testtask.testapplication.ui.component.utils.Constants.HEIGHT_OF_INPUT_FIELD
import ru.testtask.testapplication.ui.component.utils.Constants.HORIZONTAL_PADDING_TEXT_IN_INPUT_FIELD
import ru.testtask.testapplication.ui.component.utils.Constants.ICON_SIZE_IN_INPUT_FIELD
import ru.testtask.testapplication.ui.theme.NeutralActiveColor
import ru.testtask.testapplication.ui.theme.NeutralOffWhiteColor
import ru.testtask.testapplication.ui.theme.NeutralLineColor
import ru.testtask.testapplication.ui.theme.NeutralDisabledColor
import ru.testtask.testapplication.ui.theme.bodyText1


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InputField(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    disable: Boolean = false,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    iconLeft: Painter? = null,
    iconRight: Painter? = null,
    color: Color = NeutralActiveColor,
    placeholderColor: Color = NeutralDisabledColor,
    borderColor: Color = NeutralLineColor,
    onClickRightIcon: (() -> Unit?)? = null,
    onClickLeftIcon: (() -> Unit)? = null,
    onEnter: (state: TextFieldState) -> Unit = {},
){
    val focusManager = LocalFocusManager.current
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isEmpty by remember {
        derivedStateOf { state.text.isEmpty() }
    }
    val hintColor = if (isEmpty) placeholderColor else Color.Transparent
    val contentColor = if (isEmpty && !isFocused) placeholderColor else color

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(HEIGHT_OF_INPUT_FIELD.dp)
            .focusable(interactionSource = interactionSource)
            .hoverable(interactionSource = interactionSource)
            .clip(RoundedCornerShape(CORNER_RADIUS_OF_INPUT_FIELD.dp))
            .background(NeutralOffWhiteColor)
            .focusedBorder(isFocused && isEmpty, borderColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        iconLeft?.let {
            Icon(
                modifier = Modifier
                    .clickable { onClickLeftIcon?.let { onClickLeftIcon() } }
                    .padding(vertical = 9.dp, horizontal = 8.dp)
                    .size(ICON_SIZE_IN_INPUT_FIELD.dp),
                painter = it,
                tint = contentColor,
                contentDescription = ""
            )
        }
        Box(
            modifier = Modifier
                .weight(1f, true)
                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                modifier = Modifier.padding(horizontal = HORIZONTAL_PADDING_TEXT_IN_INPUT_FIELD.dp),
                text = placeholder,
                style = MaterialTheme.typography.bodyText1,
                color = hintColor,
            )

            BasicTextField2(
                modifier = Modifier.fillMaxWidth().padding(horizontal = HORIZONTAL_PADDING_TEXT_IN_INPUT_FIELD.dp),
                enabled = !disable,
                state = state,
                lineLimits = TextFieldLineLimits.SingleLine,
                cursorBrush = SolidColor(color),
                textStyle = MaterialTheme.typography.bodyText1.copy(color = color),
                interactionSource = interactionSource,
                keyboardActions = KeyboardActions(
                    onSearch = {
                        focusManager.clearFocus()
                        onEnter(state)
                    },
                ),
            )
        }
        iconRight?.let {
            Icon(
                modifier = Modifier
                    .clickable { onClickRightIcon?.let { onClickRightIcon() } }
                    .padding(vertical = 9.dp, horizontal = 8.dp)
                    .size(ICON_SIZE_IN_INPUT_FIELD.dp),
                painter = it,
                tint = contentColor,
                contentDescription = ""
            )
        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.focusedBorder(isActive: Boolean = false, borderColor: Color) = composed {
    return@composed  if (isActive) {
        this.border(FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD.dp, borderColor, RoundedCornerShape(CORNER_RADIUS_OF_INPUT_FIELD.dp))
    } else this
}