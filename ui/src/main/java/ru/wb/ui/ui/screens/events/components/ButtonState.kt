package ru.wb.ui.ui.screens.events.components

sealed class ButtonState(val id: String, val label: String) {
    data object DEFAULT: ButtonState(id = "default", label = "Пойду на встречу!")
    data object PRESSED: ButtonState(id = "pressed", label = "Схожу в другой раз")
    data object UNPRESSED: ButtonState(id = "unpressed", label = "Пойду на встречу!")
}