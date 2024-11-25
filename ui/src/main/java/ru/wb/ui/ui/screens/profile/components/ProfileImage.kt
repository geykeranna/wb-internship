package ru.wb.ui.ui.screens.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource

@Composable
internal fun ProfileImage(
    src: String?,
    modifier: Modifier = Modifier
) {
    when {
        src.isNullOrEmpty() -> {
            AsyncImage(
                modifier = modifier,
                model = src,
                contentDescription = "profile img",
                contentScale = ContentScale.Crop
            )
        }
        else -> {
            DotLottieAnimation(
                modifier = modifier,
                source = DotLottieSource.Asset("no_profile_animation.json"),
                autoplay = true,
                loop = true,
            )
        }
    }
}