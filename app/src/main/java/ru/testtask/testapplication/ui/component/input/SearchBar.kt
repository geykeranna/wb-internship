package ru.testtask.testapplication.ui.component.input

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ru.testtask.testapplication.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    disable: Boolean = false,
    onEnter: (result: String) -> Unit = {},
    state: TextFieldState,
){
    InputField(
        modifier = modifier,
        iconLeft = painterResource(id = R.drawable.ic_search),
        placeholder = placeholder ?: "Поиск",
        state = state,
        onEnter = { onEnter(it.text.toString()) },
        disable = disable
    )
}