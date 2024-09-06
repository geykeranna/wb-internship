package ru.wb.ui.ui.component.cards.events

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.wb.domain.model.EventData
import ru.wb.ui.ui.component.avatars.EventAvatar
import ru.wb.ui.ui.component.chips.TagsChips
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun EventCard(
    eventData: EventData,
    modifier: Modifier = Modifier,
    size: EventSize = EventSize.THIN,
    onNavigate: (id: String) -> Unit = {},
){
    val fontLabel = when (size) {
        EventSize.WIDE -> AppTheme.typography.heading1
        EventSize.LARGE -> AppTheme.typography.heading2
        else -> AppTheme.typography.heading3
    }

    Column(
        modifier = modifier
            .setWidth(size.width)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onNavigate(eventData.id) },
        verticalArrangement = Arrangement.spacedBy(SPACE_BY_MAIN_BLOCK_IN_EVENT_CARD.dp)
    ) {
        EventAvatar(
            modifier = Modifier
                .height(size.height.dp)
                .fillMaxWidth(),
            src = eventData.icon,
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(SPACE_BY_TEXT_BLOCK_IN_EVENT_CARD.dp)
        ) {
            Text(
                modifier = Modifier,
                text = eventData.name,
                style = fontLabel,
                color = AppTheme.colors.neutralColorFont,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
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

@SuppressLint("UnnecessaryComposedModifier")
private fun Modifier.setWidth(width: Int) = composed {
    return@composed  if (width != 0) {
        this.width(width.dp)
    } else this.fillMaxWidth()
}