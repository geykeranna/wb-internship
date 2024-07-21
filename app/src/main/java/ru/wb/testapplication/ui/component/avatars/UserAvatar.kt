package ru.wb.testapplication.ui.component.avatars

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.wb.testapplication.R
import ru.wb.testapplication.ui.theme.BlueDarkColor
import ru.wb.testapplication.ui.theme.BrandLightModeColor
import ru.wb.testapplication.ui.theme.NeutralLineColor

@Composable
fun UserAvatar(
    status: Boolean = false,
    story: Boolean = false,
    colorBadge: Color = BlueDarkColor,
    background: Color = NeutralLineColor,
    src: String? = null,
) {
    Box(
        modifier = Modifier
            .size(56.dp),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .storyBorder(story)
                .padding(4.dp)
                .border(2.dp, BrandLightModeColor, RoundedCornerShape(16.dp))
            ,
        ) {
            if (src.isNullOrEmpty()) {
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(background),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "user avatar"
                )
            } else {
                AsyncImage(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    model = src,
                    contentDescription = "profile",
                )
            }
        }

        if(status) {
            Box(modifier = Modifier
                .align(Alignment.TopEnd)
                .size(16.dp)
                .clip(CircleShape)
                .background(colorBadge)
                .border(2.dp, Color.White, CircleShape)
                .padding(2.dp)
            )
        }
    }
}

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.storyBorder(story: Boolean) = composed {
    if(story)
        return@composed this.border(
            2.dp,
            Brush.linearGradient(
                colors = listOf(BrandLightModeColor, BlueDarkColor),
                start = Offset(0f, Float.POSITIVE_INFINITY),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            ),
            RoundedCornerShape(18.dp)
        )
    return@composed this
}

