package ru.wb.ui.ui.component.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    phone: String,
    selectedPhoneCountryCode: CountryCodes,
    modifier: Modifier = Modifier,
    isAccent: Boolean = true,
    isByFullPlaceholder: Boolean = false,
    onChange: (value: String) -> Unit = {},
    onEnterClick: () -> Unit = {},
) {
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        when {
            isAccent -> focusRequester.requestFocus()
        }
    }

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester),
        value = phone,
        cursorBrush = SolidColor(Color.Transparent),
        onValueChange = {
            val value = it
                .replace("\\D", "")
                .take(selectedPhoneCountryCode.mask.count { num -> num == CHAR_IN_MASK_FOR_NUMBER })
            onChange(value)
        },
        textStyle = AppTheme.typography.bodyText1.copy(
            color = AppTheme.colors.neutralColorFont
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = { onEnterClick() },
        ),
        visualTransformation = PhoneNumberVisualTransformation(mask = selectedPhoneCountryCode.mask),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(CORNER_RADIUS_IN_NUMBER_INPUT_FIELD.dp))
                    .fillMaxWidth()
                    .background(AppTheme.colors.neutralColorSecondaryBackground)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (phone.isEmpty()){
                    Text(
                        text = "${
                            if(isByFullPlaceholder) { selectedPhoneCountryCode.countryCode } else ""
                        } ${selectedPhoneCountryCode.mask}",
                        style = AppTheme.typography.bodyText1,
                        color = AppTheme.colors.neutralColorDisabled
                    )
                }
                innerTextField()
            }
        }
    )
}