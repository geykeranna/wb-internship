package ru.testtask.testapplication.ui.component.navigation

import ru.testtask.testapplication.R


sealed class NavBar(
    val label: String,
    val icon: Int,
    val route: String,
    val focused: Int,
) {
    data object Meeting: NavBar(
        label = "Встречи",
        icon = R.drawable.ic_coffee,
        route = "meeting",
        focused = R.drawable.ic_choisen
    )

    data object Community: NavBar (
        label = "Сообщества",
        icon = R.drawable.ic_group,
        route = "community",
        focused = R.drawable.ic_choisen
    )

    data object More: NavBar (
        label = "Ещё",
        icon = R.drawable.ic_more_horizontal,
        route = "more",
        focused = R.drawable.ic_choisen
    )
}
