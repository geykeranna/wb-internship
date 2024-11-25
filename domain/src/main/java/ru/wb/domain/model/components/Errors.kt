package ru.wb.domain.model.components

enum class Errors(
    val error: String,
    val isVisible: Boolean = false,
    val code: Int? = null,
    val message: String? = null,
) {
    NETWORK_ERROR("Ошибка подключения", isVisible = true),
    AUTH_ERROR("Ошибка авторизации"),
    DATABASE_ERROR("Ошибка внутреннего хранилища", isVisible = true),
    UI_ERROR("Ошибка интерфейса", isVisible = true),
}
