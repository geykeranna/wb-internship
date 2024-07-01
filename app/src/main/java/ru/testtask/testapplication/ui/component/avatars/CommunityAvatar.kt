package ru.testtask.testapplication.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.testtask.testapplication.R

@Composable
fun CommunityAvatar (
    modifier: Modifier = Modifier,
    src: String? = null,
) {
    val mod = modifier
        .clip(RoundedCornerShape(16.dp))
        .size(48.dp)

    if (src.isNullOrEmpty()) {
        Image(
            modifier = mod,
            painter = painterResource(R.drawable.group_avatar),
            contentDescription = "avatar"
        )
    } else {
        AsyncImage(
            modifier = mod,
            model = src,
            contentDescription = "avatar",
        )
    }
}