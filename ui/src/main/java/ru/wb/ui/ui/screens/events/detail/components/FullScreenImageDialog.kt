package ru.wb.ui.ui.screens.events.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import ru.wb.ui.R
import ru.wb.ui.ui.component.utils.Constants.HEIGHT_MAP_FULL_WINDOW
import ru.wb.ui.ui.component.utils.Constants.WIDTH_MAP_FULL_WINDOW

@Composable
internal fun FullScreenImageDialog(
    isMapFullScreen: MutableState<Boolean>
) {
    if (isMapFullScreen.value) {
        Dialog(onDismissRequest = { isMapFullScreen.value = false }) {
            var scale by remember { mutableFloatStateOf(1f) }
            var offset by remember { mutableStateOf(Offset.Zero) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(WIDTH_MAP_FULL_WINDOW / HEIGHT_MAP_FULL_WINDOW)
            ) {
                Image(
                    painter = painterResource(R.drawable.defaultmap),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offset.x,
                            translationY = offset.y
                        )
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                scale = (scale * zoom).coerceIn(1f, 5f)

                                val maxOffsetX = (scale - 1) * size.width / 2
                                val maxOffsetY = (scale - 1) * size.height / 2

                                offset = Offset(
                                    x = (offset.x + pan.x * scale).coerceIn(
                                        -maxOffsetX,
                                        maxOffsetX
                                    ),
                                    y = (offset.y + pan.y * scale).coerceIn(-maxOffsetY, maxOffsetY)
                                )
                            }
                        }
                )
            }
        }
    }
}