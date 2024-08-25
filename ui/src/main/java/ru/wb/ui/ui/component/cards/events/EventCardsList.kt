package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_EVENT_ITEM_LIST

@Composable
internal fun EventCardsList(
    itemsList: List<EventData>,
    modifier: Modifier = Modifier,
    size: EventSize = EventSize.THIN,
    onNavigate: (id: String) -> Unit = {},
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_EVENT_ITEM_LIST.dp),
    ) {
        items(itemsList.size) { index ->
            EventCard(
                modifier = Modifier.fillMaxWidth(),
                eventData = itemsList[index],
                size = size,
                onNavigate = onNavigate,
            )
        }
    }
}