package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.utils.Constants.CONTENT_PADDING_OF_EVENT_ITEM_LIST

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCardsList(
    itemsList: List<EventData>,
    modifier: Modifier = Modifier,
    size: EventSize = EventSize.THIN,
    onNavigate: (id: String) -> Unit = {},
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_EVENT_ITEM_LIST.dp),
        verticalArrangement = Arrangement.spacedBy(CONTENT_PADDING_OF_EVENT_ITEM_LIST.dp),
    ) {
        itemsList.forEach { item ->
            EventCard(
                modifier = Modifier.fillMaxWidth(),
                eventData = item,
                size = size,
                onClick = { onNavigate(item.id) },
                src = item.icon
            )
        }
    }
}