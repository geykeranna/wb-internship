package ru.wb.ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    colorStyle: ColorStyle = ColorStyle.Base,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    when (colorStyle) {
        ColorStyle.Base -> baseLightPallet
    }

    CompositionLocalProvider(
        LocalColors provides baseLightPallet,
        LocalTypo provides AppTypo,
        content = content
    )
}