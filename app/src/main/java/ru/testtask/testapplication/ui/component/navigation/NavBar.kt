package ru.testtask.testapplication.ui.component.navigation

import ru.testtask.testapplication.R


sealed class NavBar(
    val label: String,
    val icon: Int,
    val route: String,
    val focused: Int,
) {
    data object Event: NavBar(
        label = "Встречи",
        icon = R.drawable.ic_coffee,
        route = Screen.Events.route,
        focused = R.drawable.ic_choisen
    )

    data object Community: NavBar (
        label = "Сообщества",
        icon = R.drawable.ic_group,
        route = Screen.Community.route,
        focused = R.drawable.ic_choisen
    )

    data object More: NavBar (
        label = "Ещё",
        icon = R.drawable.ic_more_horizontal,
        route = Screen.More.route,
        focused = R.drawable.ic_choisen
    )
}
