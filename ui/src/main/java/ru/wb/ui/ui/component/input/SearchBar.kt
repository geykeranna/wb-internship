package ru.wb.ui.ui.component.input

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.wb.ui.R

@Composable
internal fun SearchBar(
    value: String,
    modifier: Modifier = Modifier,
    disable: Boolean = false,
    onChangeValue: (result: String) -> Unit = {},
){
    InputField(
        modifier = modifier,
        iconLeft = painterResource(id = R.drawable.ic_search),
        placeholder = stringResource(R.string.placeholder_in_search_field),
        value = value,
        disable = disable,
        onChangeValue = onChangeValue
    )
}