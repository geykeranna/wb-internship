package ru.testtask.testapplication.ui.component.avatars

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
import ru.testtask.testapplication.R
import ru.testtask.testapplication.ui.theme.GrayLightColor

@Composable
fun ProfileAvatar(
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
                .background(GrayLightColor),
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
                    .clickable { onFloatingClick },
                painter = painterResource(id = R.drawable.ic_plus_circle),
                contentDescription = "profile"
            )
        }
    }
}

enum class ProfileSize(val boxSize: Int,
                       val iconSize: Int,
                       val floatingBntSize: Int
) {
    NORMAL(
        boxSize = 100,
        iconSize = 44,
        floatingBntSize = 20,
    ),
    LARGE(
        boxSize = 200,
        iconSize = 88,
        floatingBntSize = 40,
    )
}