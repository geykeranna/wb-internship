package ru.wb.ui.ui.component.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_INPUT_FIELD
import ru.wb.ui.ui.component.utils.Constants.FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD

@SuppressLint("UnnecessaryComposedModifier")
internal fun Modifier.focusedBorder(isActive: Boolean = false, borderColor: Color) = composed {
    return@composed  if (isActive) {
        this.border(
            FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD.dp, borderColor, RoundedCornerShape(
                CORNER_RADIUS_OF_INPUT_FIELD.dp)
        )
    } else this
}

internal fun Modifier.onClick(
    disabled: Boolean,
    onClick: () -> Unit
): Modifier {
    return if (!disabled) { this.noRippleClickable { onClick() } } else this
}

@SuppressLint("ModifierFactoryUnreferencedReceiver", "UnnecessaryComposedModifier")
inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

internal fun shareUser(context: Context, value: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, value)
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(shareIntent, null))
}