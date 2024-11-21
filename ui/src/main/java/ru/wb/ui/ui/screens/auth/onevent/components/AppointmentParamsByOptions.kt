package ru.wb.ui.ui.screens.auth.onevent.components

internal fun appointmentGetParamsByOptions(
    options: String
): List<String> {
    val values = options.split(';')
    var description = ""
    var title: AppointmentScreenTitle = AppointmentScreenTitle.USER
    var id = ""
    values.forEach { value ->
        try {
            when {
                value.contains("description") -> description = value.split('=')[1]
                value.contains("event") -> {
                    title = AppointmentScreenTitle.EVENT
                    id = value.split('=')[1]
                }
                value.contains("community") -> {
                    title = AppointmentScreenTitle.COMMUNITY
                    id = value.split('=')[1]
                }
                value.contains("user") -> {
                    title = AppointmentScreenTitle.USER
                }
            }
        } catch (_: Throwable) {}
    }
    return listOf(title.title, description, id)
}

internal fun appointmentGetOptionsByParams(
    description: String,
    from: String,
    id: String = "",
): String {
    return "/description=$description;$from=$id"
}