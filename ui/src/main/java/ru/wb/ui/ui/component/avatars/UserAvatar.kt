package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.visitors.AvatarsSize
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR_IN_CARD
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun UserAvatar(
    modifier: Modifier = Modifier,
    src: String? = null,
    size: AvatarsSize = AvatarsSize.SMALL
) {
    val mod = when(size) {
        AvatarsSize.NORMAL -> {
            modifier
                .clip(CircleShape)
                .size(SIZE_USER_AVATAR_IN_CARD.dp)
        }
        else -> {
            modifier
                .clip(CircleShape)
                .size(SIZE_USER_AVATAR.dp)
        }
    }

    when {
        !src.isNullOrEmpty() -> {
            AsyncImage(
                modifier = mod,
                model = src,
                contentDescription = "user avatar",
            )
        }
        else -> {
            Image(
                modifier = mod
                    .background(color = AppTheme.colors.neutralColorDivider),
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "user avatar"
            )
        }
    }
}

