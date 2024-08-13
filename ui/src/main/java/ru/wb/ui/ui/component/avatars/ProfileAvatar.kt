package ru.wb.ui.ui.component.avatars

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.ui.R
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun ProfileAvatar(
    modifier: Modifier = Modifier,
    onFloatingClick: () -> Unit = {},
    isFloatingVisible: Boolean = false,
    size: ProfileSize = ProfileSize.NORMAL,
    src: String? = null
) {
    Box(modifier = modifier){
        Box(
            modifier = Modifier
                .size(size.boxSize.dp)
                .clip(CircleShape)
                .background(color = AppTheme.colors.neutralColorDivider),
            contentAlignment = Alignment.Center
        ){
            if (src.isNullOrEmpty()) {
                Image(
                    modifier = Modifier
                        .size(size.iconSize.dp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "profile"
                )
            } else {
                AsyncImage(
                    modifier = Modifier
                        .size(size.iconSize.dp),
                    model = src,
                    contentDescription = "profile",
                )
            }
        }
        if (isFloatingVisible) {
            Image(
                modifier = modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 3.dp)
                    .size(size.floatingBntSize.dp)
                    .clip(CircleShape)
                    .clickable { onFloatingClick() },
                painter = painterResource(id = R.drawable.ic_plus_circle),
                contentDescription = "profile"
            )
        }
    }
}