package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.IMAGE_RADIUS_IMAGE_IN_EVENT_CARD

@Composable
internal fun EventAvatar(
    modifier: Modifier = Modifier,
    src: String? = null,
) {
    val mod = modifier
        .clip(RoundedCornerShape(IMAGE_RADIUS_IMAGE_IN_EVENT_CARD.dp))

    when {
        !src.isNullOrEmpty() -> {
            AsyncImage(
                modifier = mod,
                model = src,
                contentDescription = "avatar",
                contentScale = ContentScale.Crop
            )
        }
        else -> {
            Image(
                modifier = mod,
                painter = painterResource(R.drawable.default_wide_img),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop
            )
        }
    }
}