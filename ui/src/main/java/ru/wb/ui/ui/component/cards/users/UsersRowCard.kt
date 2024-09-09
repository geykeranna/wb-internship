package ru.wb.ui.ui.component.cards.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.cards.visitors.UserShortCard

@Composable
internal fun UsersRowCard(
    itemsList: List<UserData>,
    modifier: Modifier = Modifier,
    onNavigate: (idUser: String) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(itemsList){ item ->
            UserShortCard(
                modifier = Modifier.clickable { onNavigate(item.id) },
                userData = item,
            )
        }
    }
}