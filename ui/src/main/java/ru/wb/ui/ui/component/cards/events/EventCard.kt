package ru.wb.ui.ui.component.cards.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.avatars.EventAvatar
import ru.wb.ui.ui.component.chips.ChipsData
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_METADATA_TEXT_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun EventCard(
    eventData: EventData,
    modifier: Modifier = Modifier,
    size: EventSize = EventSize.THIN,
    src: String? = null,
    onClick: () -> Unit = {},
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD.dp)
    ) {
        EventAvatar(
            src = src,
            size = size
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD.dp)
        ) {
            Text(
                modifier = Modifier,
                text = eventData.name,
                style = AppTheme.typography.headingLabelMeeting,
                color = AppTheme.colors.neutralColorFont
            )

            Text(
                modifier = Modifier,
                text = "${eventData.date} — ${eventData.location.city}",
                style = AppTheme.typography.metadata1.copy(lineHeight = HEIGHT_OF_METADATA_TEXT_IN_EVENT_CARD.sp),
                color = AppTheme.colors.neutralColorDisabled
            )
        }

        TagsChips (
            data = eventData.tagList.map { ChipsData(id = "key", name = it) }
        )
    }
}