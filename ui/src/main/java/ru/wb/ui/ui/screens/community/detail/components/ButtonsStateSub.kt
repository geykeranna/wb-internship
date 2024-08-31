package ru.wb.ui.ui.screens.community.detail.components

internal sealed class ButtonsStateSub(
    val id: String,
    val label: String,
) {
    data object DEFAULT: ButtonsStateSub(id = "default", label = "Подписаться")
    data object PRESSED: ButtonsStateSub(id = "pressed", label = "Вы подписаны")
    data object UNPRESSED: ButtonsStateSub(id = "unpressed", label = "Подписаться")
}