package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventItemData

@Composable
internal fun EventCardsColumnList(
    itemsList: List<EventItemData>,
    modifier: Modifier = Modifier,
    size: EventSize = EventSize.LARGE,
    onNavigate: (id: String) -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(40.dp),
    ) {
        itemsList.map { item ->
            EventCard(
                modifier = Modifier.fillMaxWidth(),
                eventData = item,
                size = size,
                onNavigate = onNavigate
            )
        }
    }
}