package ru.wb.ui.ui.component.avatars

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.BORDER_RADIUS_USER_AVATAR
import ru.wb.ui.ui.component.utils.Constants.BORDER_SIZE_USER_AVATAR
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_USER_AVATAR_IMAGE
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_USER_AVATAR_ITEM
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR
import ru.wb.ui.ui.component.utils.Constants.SIZE_USER_AVATAR_IMAGE
import ru.wb.ui.ui.component.utils.Constants.STATUS_SIZE_USER_AVATAR
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun UserAvatar(
    status: Boolean = false,
    story: Boolean = false,
    src: String? = null,
) {
    Box(
        modifier = Modifier
            .size(SIZE_USER_AVATAR.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .storyBorder(story)
                .padding(4.dp)
                .border(
                    width = BORDER_SIZE_USER_AVATAR.dp,
                    color = AppTheme.colors.gradientColorBackground,
                    shape = RoundedCornerShape(CORNER_RADIUS_USER_AVATAR_ITEM.dp)
                )
            ,
        ) {
            if (src.isNullOrEmpty()) {
                Image(
                    modifier = Modifier
                        .size(SIZE_USER_AVATAR_IMAGE.dp)
                        .clip(RoundedCornerShape(CORNER_RADIUS_USER_AVATAR_IMAGE.dp))
                        .background(color = AppTheme.colors.neutralColorDivider),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "user avatar"
                )
            } else {
                AsyncImage(
                    modifier = Modifier
                        .size(SIZE_USER_AVATAR_IMAGE.dp)
                        .clip(RoundedCornerShape(CORNER_RADIUS_USER_AVATAR_IMAGE.dp)),
                    model = src,
                    contentDescription = "profile",
                )
            }
        }

        if(status) {
            Box(modifier = Modifier
                .align(Alignment.TopEnd)
                .size(STATUS_SIZE_USER_AVATAR.dp)
                .clip(CircleShape)
                .background(AppTheme.colors.brandColorDefault)
                .border(BORDER_SIZE_USER_AVATAR.dp, AppTheme.colors.neutralColorBackground, CircleShape)
                .padding(BORDER_SIZE_USER_AVATAR.dp)
            )
        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.storyBorder(story: Boolean) = composed {
    if(story)
        return@composed this.border(
            width = BORDER_SIZE_USER_AVATAR.dp,
            brush = AppTheme.colors.gradient1,
            shape = RoundedCornerShape(BORDER_RADIUS_USER_AVATAR.dp)
        )
    return@composed this
}

