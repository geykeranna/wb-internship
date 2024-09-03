package ru.wb.ui.ui.screens.profile.components

internal enum class ProfilePageMode(
    val bottomBarText: String,
    val eventLabelText: String,
    val communityLabelText: String,
) {
    VIEW_INSIDE(
        bottomBarText = "Выйти",
        eventLabelText = "Мои встречи",
        communityLabelText = "Мои сообщества",
    ),
    VIEW_OUTSIDE(
        bottomBarText = "",
        eventLabelText = "Встречи",
        communityLabelText = "Сообщества",
    ),
    EDIT(
        bottomBarText = "Удалить аккаунт",
        eventLabelText = "",
        communityLabelText = "",
    ),
}