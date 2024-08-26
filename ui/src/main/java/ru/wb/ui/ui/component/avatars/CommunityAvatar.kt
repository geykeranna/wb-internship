package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.component.cards.community.CommunitySize
import ru.wb.ui.ui.component.utils.Constants.IMG_RADIUS_COMMUNITY_AVATAR_FULL
import ru.wb.ui.ui.component.utils.Constants.IMG_RADIUS_COMMUNITY_AVATAR_SMALL
import ru.wb.ui.ui.component.utils.Constants.IMG_SIZE_COMMUNITY_AVATAR_FULL
import ru.wb.ui.ui.component.utils.Constants.IMG_SIZE_COMMUNITY_AVATAR_SMALL
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun CommunityAvatar (
    modifier: Modifier = Modifier,
    src: String? = null,
    isVerified: Boolean = false,
    size: CommunitySize = CommunitySize.SMALL
) {
    val mod = when (size) {
        CommunitySize.FULL -> {
            Modifier
                .size(IMG_SIZE_COMMUNITY_AVATAR_FULL.dp)
                .clip(RoundedCornerShape(IMG_RADIUS_COMMUNITY_AVATAR_FULL.dp))
        }
        else -> {
            Modifier
                .size(IMG_SIZE_COMMUNITY_AVATAR_SMALL.dp)
                .clip(RoundedCornerShape(IMG_RADIUS_COMMUNITY_AVATAR_SMALL.dp))
        }
    }

    Box(
        modifier = modifier
    ) {
        when {
            !src.isNullOrEmpty() -> {
                AsyncImage(
                    modifier = mod,
                    model = src,
                    contentDescription = "community_avatar",
                )
            }
            else -> {
                Image(
                    modifier = mod,
                    painter = painterResource(R.drawable.group_avatar),
                    contentDescription = "community_avatar"
                )
            }
        }

        if(isVerified) {
            Box(
                modifier = Modifier
                    .size(37.dp)
                    .padding(start = 4.dp, bottom = 8.dp)
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(12.dp))
                    .background(AppTheme.colors.brandColorLight)
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_check_big),
                    contentDescription = "verified_account",
                    tint = AppTheme.colors.brandColorDefault
                )
            }
        }
    }
}