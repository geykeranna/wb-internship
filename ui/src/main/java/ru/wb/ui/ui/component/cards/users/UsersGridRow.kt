package ru.wb.ui.ui.component.cards.users

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.UserData
import ru.wb.ui.ui.component.cards.visitors.UserShortCard

@Composable
internal fun UsersGridRow(
    dataList: List<UserData>,
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Adaptive(minSize = 104.dp),
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        items(dataList) { user ->
            UserShortCard(userData = user)
        }
    }
}