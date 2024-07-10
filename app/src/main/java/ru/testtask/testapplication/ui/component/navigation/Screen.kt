package ru.testtask.testapplication.ui.component.navigation

sealed class Screen(val route: String, val name: String) {

    data object Splash: Screen(
        route = "splash",
        name = "Сплеш"
    )

    data object Events: Screen(
        route = "event",
        name = "Встречи"
    )

    data object EventsDetail: Screen(
        route = "event_detail",
        name = "Экран детального просмотра"
    )

    data object CommunityDetail: Screen(
        route = "community_detail",
        name = "Экран детального просмотра"
    )

    data object Community: Screen(
        route = "community",
        name = "Сообщества"
    )

    data object More: Screen(
        route = "more",
        name = "Ещё"
    )

    data object Profile: Screen(
        route = "more_profile",
        name = "Профиль"
    )

    data object MyEvents: Screen(
        route = "more_my_meets",
        name = "Мои встречи"
    )
}