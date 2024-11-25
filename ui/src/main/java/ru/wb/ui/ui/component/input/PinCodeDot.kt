package ru.wb.ui.ui.component.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ru.wb.ui.ui.component.utils.Constants.SIZE_OF_PASS_ITEMS
import ru.wb.ui.ui.theme.AppTheme

@Composable
internal fun PinCodeDot(
    value: String,
    index: Int,
    isInvalid: Boolean = false,
) {
    val offsetX = remember { Animatable(0f) }
    val animTime = 100
    val delay = 400L
    LaunchedEffect(isInvalid) {
        if (isInvalid){
            delay(delay)
            offsetX.animateTo(targetValue = -30f, animationSpec = tween(durationMillis = animTime))
            offsetX.animateTo(targetValue = 0f, animationSpec = tween(durationMillis = animTime))
            offsetX.animateTo(targetValue = 30f, animationSpec = tween(durationMillis = animTime))
            offsetX.animateTo(targetValue = 0f, animationSpec = tween(durationMillis = animTime))
        }
    }
    val backgroundColor = when{
        isInvalid -> AppTheme.colors.neutralColorInvalidBackground
        else -> AppTheme.colors.neutralColorDivider
    }
    val animatedModifier = Modifier.offset(x = offsetX.value.dp)

    Column(
        modifier = Modifier
            .size(SIZE_OF_PASS_ITEMS.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedVisibility(
            visible = index !in value.indices,
        ) {
            Box(
                modifier = animatedModifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(backgroundColor)
            )
        }

        AnimatedVisibility(
            visible = index in value.indices,
        ) {
            Text(
                modifier = animatedModifier,
                text = value.getOrElse(index) { ' ' }.toString(),
                style = AppTheme.typography.heading1,
                color = AppTheme.colors.neutralColorFont
            )
        }
    }
}