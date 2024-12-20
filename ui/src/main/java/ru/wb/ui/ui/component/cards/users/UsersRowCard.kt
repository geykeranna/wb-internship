package ru.wb.ui.ui.component.cards.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserItemsData
import ru.wb.ui.ui.component.cards.visitors.UserShortCard
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON
import ru.wb.ui.ui.component.utils.noRippleClickable

@Composable
internal fun UsersRowCard(
    itemsList: List<UserItemsData>,
    modifier: Modifier = Modifier,
    onNavigate: (idUser: String) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            start = HORIZONTAL_PADDING_CONTENT_COMMON.dp,
            end = HORIZONTAL_PADDING_CONTENT_COMMON.dp
        )
    ) {
        items(itemsList){ item ->
            UserShortCard(
                modifier = Modifier.noRippleClickable { onNavigate(item.id) },
                userData = item,
            )
        }
    }
}