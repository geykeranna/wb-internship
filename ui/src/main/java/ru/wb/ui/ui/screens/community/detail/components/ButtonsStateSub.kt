package ru.wb.ui.ui.screens.community.detail.components

internal enum class ButtonsStateSub(
    val id: String,
    val label: String,
) {
    DEFAULT(id = "default", label = "Подписаться"),
    PRESSED(id = "pressed", label = "Вы подписаны"),
    UNPRESSED(id = "unpressed", label = "Подписаться"),
}