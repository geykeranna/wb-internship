package ru.wb.ui.ui.base

enum class BaseState(val massage: String) {
    LOADING(massage = "Загрузка..."),
    EMPTY(massage = "Нет данных"),
    ERROR(massage = "Ошибка получения данных"),
    SUCCESS(massage = "")
}