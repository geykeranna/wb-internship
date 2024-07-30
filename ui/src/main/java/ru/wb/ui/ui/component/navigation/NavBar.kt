package ru.wb.ui.ui.component.navigation

import ru.wb.ui.R

internal sealed class NavBar(
    val label: String,
    val icon: Int,
    val route: String,
    val focused: Int,
) {
    data object Event: NavBar(
        label = Screen.EVENTS.label,
        icon = R.drawable.ic_coffee,
        route = Screen.EVENTS.route,
        focused = R.drawable.ic_choisen
    )

    data object Community: NavBar(
        label = Screen.COMMUNITY.label,
        icon = R.drawable.ic_group,
        route = Screen.COMMUNITY.route,
        focused = R.drawable.ic_choisen
    )

    data object More: NavBar(
        label = Screen.MORE.label,
        icon = R.drawable.ic_more_horizontal,
        route = Screen.MORE.route,
        focused = R.drawable.ic_choisen
    )
}
