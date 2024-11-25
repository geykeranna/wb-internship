package ru.wb.ui.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

object AppTheme {
    val colors: Colors
        @Composable
        get() = LocalColors.current

    val typography: AppTypo
        @Composable
        get() = LocalTypo.current
}

internal val LocalColors = staticCompositionLocalOf { baseLightPallet }
internal val LocalTypo = staticCompositionLocalOf { AppTypo }