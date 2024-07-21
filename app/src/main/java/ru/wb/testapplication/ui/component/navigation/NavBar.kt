package ru.wb.testapplication.ui.component.navigation

import ru.wb.testapplication.R

sealed class NavBar(
    val label: String,
    val icon: Int,
    val route: String,
    val focused: Int,
) {
    data object Event: NavBar(
        label = Screen.Events.name,
        icon = R.drawable.ic_coffee,
        route = Screen.Events.route,
        focused = R.drawable.ic_choisen
    )

    data object Community: NavBar (
        label = Screen.Community.name,
        icon = R.drawable.ic_group,
        route = Screen.Community.route,
        focused = R.drawable.ic_choisen
    )

    data object More: NavBar (
        label = Screen.More.name,
        icon = R.drawable.ic_more_horizontal,
        route = Screen.More.route,
        focused = R.drawable.ic_choisen
    )
}
