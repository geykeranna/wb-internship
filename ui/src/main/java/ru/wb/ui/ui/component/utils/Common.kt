package ru.wb.ui.ui.component.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.wb.ui.ui.component.utils.Constants.CORNER_RADIUS_OF_INPUT_FIELD
import ru.wb.ui.ui.component.utils.Constants.FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD

@SuppressLint("UnnecessaryComposedModifier")
fun Modifier.focusedBorder(isActive: Boolean = false, borderColor: Color) = composed {
    return@composed  if (isActive) {
        this.border(
            FOCUSED_BORDER_WIDTH_IN_INPUT_FIELD.dp, borderColor, RoundedCornerShape(
                CORNER_RADIUS_OF_INPUT_FIELD.dp)
        )
    } else this
}