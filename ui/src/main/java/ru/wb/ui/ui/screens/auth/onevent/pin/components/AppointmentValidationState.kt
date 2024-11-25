package ru.wb.ui.ui.screens.auth.onevent.pin.components

data class AppointmentValidationState(
    val contextString: String,
    val isActive: Boolean = false,
){
    companion object{
        val defaultValue = AppointmentValidationState(
            contextString = ""
        )
    }
}