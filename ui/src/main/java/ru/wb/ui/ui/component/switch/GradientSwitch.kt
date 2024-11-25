package ru.wb.ui.ui.component.switch

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.noRippleClickable
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun GradientSwitch(
    checked: Boolean,
    modifier: Modifier = Modifier,
    width: Int = 48,
    height: Int = 24,
    checkedTrackColor: Color = AppTheme.colors.brandColorDefault,
    uncheckedTrackColor: Color = AppTheme.colors.neutralColorDisabled,
    thumbColor: Color = AppTheme.colors.neutralColorBackground,
    onCheckedChange: (Boolean) -> Unit = {},
) {
    val thumbPosition by animateFloatAsState(
        targetValue = if (checked) 1f else 0f,
        label = "thumbPosition"
    )
    val circleRadius = remember { (height / 2 - 2).dp }

    Box(
        modifier = modifier
            .size(width = width.dp, height = height.dp)
            .background(color = Color.Transparent)
            .noRippleClickable { onCheckedChange(!checked) }
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val trackBrush = if (checked) checkedTrackColor else uncheckedTrackColor

            drawRoundRect(
                color = trackBrush,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(
                    x = (height / 2).dp.toPx(),
                    y = (height / 2).dp.toPx()
                )
            )

            val thumbOffset = calculateThumbOffset(
                start = (height / 2).dp.toPx(),
                stop = size.width - (height / 2).dp.toPx(),
                fraction = thumbPosition
            )

            drawCircle(
                color = thumbColor,
                radius = circleRadius.toPx(),
                center = Offset(x = thumbOffset, y = size.height / 2)
            )
        }
    }
}

private fun calculateThumbOffset(
    start: Float,
    stop: Float,
    fraction: Float
): Float = start + (stop - start) * fraction