package ru.wb.ui.ui.component.toolbars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wb.ui.R
import ru.wb.ui.ui.component.input.InputField
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun TopBarMain(
    modifier: Modifier = Modifier,
    inputText: String = "",
    onUserClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    onChangeValue: (text: String) -> Unit = {},
) {
    val iconRight = when {
        inputText.isNotEmpty() -> {
            painterResource(id = R.drawable.ic_close_small)
        }
        else -> {
            null
        }
    }
    val focusRequester = remember { FocusRequester() }
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        InputField(
            modifier = Modifier.weight(0.8f),
            value = inputText,
            onChangeValue = onChangeValue,
            iconRight = iconRight,
            focusRequester = focusRequester,
            onClickRightIcon = { onChangeValue("") },
            iconLeft = painterResource(id = R.drawable.ic_search),
            placeholder = stringResource(R.string.placeholder_in_search_field),
        )

        when {
            inputText.isNotEmpty() -> {
                Text(
                    modifier = Modifier
                        .clickable {
                            onCancelClick()
                            onChangeValue("")
                            focusRequester.freeFocus()
                        },
                    text = stringResource(R.string.text_cancel),
                )
            }
            else -> {
                Icon(
                    modifier = Modifier
                        .clickable { onUserClick() },
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = null,
                    tint = AppTheme.colors.brandColorDefault
                )
            }
        }
    }
}