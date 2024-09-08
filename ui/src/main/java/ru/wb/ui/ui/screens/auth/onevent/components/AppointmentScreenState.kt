package ru.wb.ui.ui.screens.auth.onevent.components

internal enum class AppointmentScreenState(
    val textButton: String = "",
) {
    ENTER_NAME("Продолжить"),
    ENTER_PHONE("Получить код"),
    ENTER_PIN("Отправить и подтвердить запись"),
}