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
import ru.testtask.testapplication.ui.theme.NaturalActiveColor
import ru.testtask.testapplication.ui.theme.NaturalOffWhiteColor
import ru.testtask.testapplication.ui.theme.NaturalLineColor
import ru.testtask.testapplication.ui.theme.NaturalDisabledColor
import ru.testtask.testapplication.ui.theme.bodyText1


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InputField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    disable: Boolean = false,
    state: TextFieldState,
    interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    },
    iconLeft: Painter? = null,
    iconRight: Painter? = null,
    color: Color = NaturalActiveColor,
    placeholderColor: Color = NaturalDisabledColor,
    borderColor: Color = NaturalLineColor,
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
            .height(36.dp)
            .focusable(interactionSource = interactionSource)
            .hoverable(interactionSource = interactionSource)
            .clip(RoundedCornerShape(4.dp))
            .background(NaturalOffWhiteColor)
            .focusedBorder(isFocused && isEmpty, borderColor),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        iconLeft?.let {
            Icon(
                modifier = Modifier
                    .clickable { onClickLeftIcon?.let { onClickLeftIcon() } }
                    .padding(vertical = 9.dp, horizontal = 8.dp)
                    .size(24.dp),
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
                text = placeholder,
                style = MaterialTheme.typography.bodyText1,
                color = hintColor,
            )

            BasicTextField2(
                modifier = Modifier.fillMaxWidth(),
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
                    .size(24.dp),
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
        this.border(2.dp, borderColor, RoundedCornerShape(4.dp))
    } else this
}