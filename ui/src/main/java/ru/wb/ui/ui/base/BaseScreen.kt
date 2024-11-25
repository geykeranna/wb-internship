package ru.wb.ui.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import ru.wb.ui.ui.base.components.BaseElementScreen

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    state: BaseState = BaseState.SUCCESS,
    content: @Composable () -> Unit = {}
) {
    when (state) {
        BaseState.LOADING -> {
            BaseElementScreen(
                modifier = modifier,
                title = BaseState.LOADING.massage
            ) {
                DotLottieAnimation(
                    source = DotLottieSource.Asset("loading_animation.json"),
                    autoplay = true,
                    loop = true
                )
            }
        }
        BaseState.ERROR -> {
            BaseElementScreen(
                modifier = modifier,
                title = BaseState.ERROR.massage
            ) {
                DotLottieAnimation(
                    source = DotLottieSource.Asset("error_animation.json"),
                    autoplay = true,
                    loop = true
                )
            }
        }
        BaseState.EMPTY -> {
            BaseElementScreen(
                modifier = modifier,
                title = BaseState.EMPTY.massage
            ) {
                DotLottieAnimation(
                    source = DotLottieSource.Asset("empty_animation.json"),
                    autoplay = true,
                    loop = true
                )
            }
        }
        BaseState.SUCCESS -> {
            Box(modifier = modifier) { content() }
        }
    }
}