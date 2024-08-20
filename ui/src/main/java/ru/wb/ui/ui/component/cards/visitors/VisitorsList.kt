package ru.wb.ui.ui.component.cards.visitors

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.avatars.UserAvatar

@Composable
internal fun VisitorsList(
    visitorsList: List<UserData>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        userScrollEnabled = false,
        horizontalArrangement = Arrangement.spacedBy((-30).dp)
    ) {
        items(visitorsList.size) {
            UserAvatar()
        }
    }
}

@Preview
@Composable
fun Preview(){
    VisitorsList(visitorsList = listOf(
        UserData.defaultObject,
        UserData.defaultObject,
        UserData.defaultObject,
        UserData.defaultObject,
        UserData.defaultObject,
        UserData.defaultObject,
        UserData.defaultObject,
    ))
}