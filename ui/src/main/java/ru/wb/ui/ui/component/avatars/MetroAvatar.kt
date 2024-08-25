package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import ru.wb.ui.R

@Composable
internal fun MetroAvatar(
    modifier: Modifier = Modifier,
    src: String? = null
) {
    when {
        !src.isNullOrEmpty() -> {
            AsyncImage(
                modifier = modifier,
                model = src,
                contentDescription = "metro",
                contentScale = ContentScale.Crop,
            )
        }
        else -> {
            Image(
                modifier = modifier,
                painter = painterResource(R.drawable.ic_help_circle),
                contentDescription = "unknown",
                contentScale = ContentScale.Crop,
            )
        }
    }
}