package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
                .background(color = AppTheme.colors.neutralColorDivider)
        }
        AvatarsSize.SQUARE -> {
            modifier
                .size(SIZE_USER_AVATAR_IN_CARD.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = AppTheme.colors.neutralColorDivider)
        }
        else -> {
            modifier
                .clip(CircleShape)
                .size(SIZE_USER_AVATAR.dp)
                .background(color = AppTheme.colors.neutralColorDivider)
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
                modifier = mod,
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "user avatar"
            )
        }
    }
}

