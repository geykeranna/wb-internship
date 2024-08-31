package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.avatars.EventAvatar
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun LargeEventCard(
    eventData: EventData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD.dp)
    ) {
        EventAvatar(
            src = eventData.icon,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD.dp)
        ) {
            Text(
                modifier = Modifier,
                text = eventData.name,
                style = AppTheme.typography.heading1,
                color = AppTheme.colors.neutralColorFont,
                overflow = TextOverflow.Visible
            )

            Text(
                modifier = Modifier,
                text = "${eventData.date} · ${eventData.location.address}",
                style = AppTheme.typography.secondary,
                color = AppTheme.colors.neutralColorDisabled,
                overflow = TextOverflow.Visible
            )
        }

        TagsChips (
            data = eventData.tagList
        )
    }
}