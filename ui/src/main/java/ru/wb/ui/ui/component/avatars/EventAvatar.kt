package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.events.EventSize
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_THIN_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_OF_WIDE_IMAGE_IN_EVENT_CARD
import ru.wb.ui.ui.component.utils.Constants.IMAGE_RADIUS_IMAGE_IN_EVENT_CARD

@Composable
internal fun EventAvatar(
    modifier: Modifier = Modifier,
    src: String? = null,
    size: EventSize = EventSize.THIN
) {
    val mod = when (size) {
        EventSize.WIDE -> modifier
            .clip(RoundedCornerShape(IMAGE_RADIUS_IMAGE_IN_EVENT_CARD.dp))
            .size(
                height = HEIGHT_OF_WIDE_IMAGE_IN_EVENT_CARD.dp,
                width = EventSize.WIDE.width.dp
            )
        else -> modifier
            .clip(RoundedCornerShape(IMAGE_RADIUS_IMAGE_IN_EVENT_CARD.dp))
            .size(
                width = EventSize.THIN.width.dp,
                height = HEIGHT_OF_THIN_IMAGE_IN_EVENT_CARD.dp
            )
    }

    when {
        !src.isNullOrEmpty() -> {
            AsyncImage(
                modifier = mod,
                model = src,
                contentDescription = "avatar"
            )
        }
        else -> {
            Image(
                modifier = mod,
                painter = painterResource(R.drawable.default_wide_img),
                contentDescription = "avatar"
            )
        }
    }
}