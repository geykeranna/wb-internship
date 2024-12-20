package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CountryCodes
import ru.wb.ui.ui.component.utils.Constants.CHAR_IN_MASK_FOR_NUMBER
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_IN_NUMBER_INPUT_FIELD
import ru.wb.ui.ui.component.utils.PhoneNumberVisualTransformation
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun InputNumberTextField(
    input: String,
    selectedPhoneCountryCode: CountryCodes,
    modifier: Modifier = Modifier,
    isAccent: Boolean = false,
    disable: Boolean = false,
    disableEnter: Boolean = false,
    isInvalid: Boolean = false,
    invalidMessage: String = "",
    isByFullPlaceholder: Boolean = false,
    onEnterClick: () -> Unit = {},
    onChange: (value: String) -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        when {
            isAccent -> focusRequester.requestFocus()
        }
    }
    val backgroundColor = when {
        isInvalid -> AppTheme.colors.neutralColorInvalidBackground
        else -> AppTheme.colors.neutralColorSecondaryBackground
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        BasicTextField(
            modifier = Modifier
                .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
                .background(backgroundColor)
                .focusRequester(focusRequester),
            value = input,
            enabled = !disable,
            cursorBrush = SolidColor(Color.Transparent),
            onValueChange = { text ->
                val value = text
                    .filter { it.isDigit() }
                    .take(selectedPhoneCountryCode.mask.count { num -> num == CHAR_IN_MASK_FOR_NUMBER })
                onChange(value)
            },
            textStyle = AppTheme.typography.regular.copy(
                color = AppTheme.colors.neutralColorFont
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = { if(disableEnter) Unit else onEnterClick() },
            ),
            visualTransformation = PhoneNumberVisualTransformation(mask = selectedPhoneCountryCode.mask),
            decorationBox = { innerTextField ->
                DecorationBoxNumberTextField(
                    value = input,
                    placeholder = "${
                        if(isByFullPlaceholder) { selectedPhoneCountryCode.countryCode } else ""
                    } ${selectedPhoneCountryCode.mask}",
                    innerTextField = innerTextField
                )
            }
        )
        if(isInvalid && invalidMessage.isNotEmpty()) {
            Text(
                text = invalidMessage,
                style = AppTheme.typography.secondary,
                color = AppTheme.colors.neutralColorInvalidText,
            )
        }
    }
}