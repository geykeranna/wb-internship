package ru.wb.ui.ui.component.avatars

internal enum class ProfileSize(val boxSize: Int,
                       val iconSize: Int,
                       val floatingBntSize: Int
) {
    NORMAL(
        boxSize = 100,
        iconSize = 44,
        floatingBntSize = 20,
    ),
    LARGE(
        boxSize = 200,
        iconSize = 88,
        floatingBntSize = 40,
    )
}