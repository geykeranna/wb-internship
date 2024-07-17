package ru.testtask.testapplication.ui.component.input

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.testtask.testapplication.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchBar(
    state: TextFieldState,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    disable: Boolean = false,
    onEnter: (result: String) -> Unit = {},
){
    InputField(
        modifier = modifier,
        iconLeft = painterResource(id = R.drawable.ic_search),
        placeholder = placeholder ?: stringResource(R.string.placeholder_in_search_field),
        state = state,
        onEnter = { onEnter(it.text.toString()) },
        disable = disable
    )
}