package ru.wb.ui.ui.component.cards.community

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.CommunityData
import ru.wb.ui.ui.component.utils.Constants.HORIZONTAL_PADDING_CONTENT_COMMON

@Composable
internal fun CommunityCardRowList(
    itemsList: List<CommunityData>,
    modifier: Modifier = Modifier,
    onClick: ((id: String) -> Unit)? = {},
    onNavigate: (id: String) -> Unit = {},
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(
            start = HORIZONTAL_PADDING_CONTENT_COMMON.dp,
            end = HORIZONTAL_PADDING_CONTENT_COMMON.dp
        )
    ) {
        items(itemsList.size) { index ->
            CommunityCard(
                modifier = Modifier.clickable { onNavigate(itemsList[index].id) },
                onAddClick = onClick,
                communityData = itemsList[index],
            )
        }
    }
}