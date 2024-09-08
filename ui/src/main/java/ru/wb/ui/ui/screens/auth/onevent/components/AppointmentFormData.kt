package ru.wb.ui.ui.screens.auth.onevent.components

internal data class AppointmentFormData(
    val name: String,
    val phone: String,
    val pin: String,
) {
    companion object {
        val defaultData = AppointmentFormData (
            name = "",
            phone = "",
            pin = "",
        )
    }
}
