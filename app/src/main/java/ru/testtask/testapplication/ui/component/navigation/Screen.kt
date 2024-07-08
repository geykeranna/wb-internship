package ru.testtask.testapplication.ui.component.navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("splash")

    data object Events: Screen("event")

    data object EventsDetail: Screen("event_detail")

    data object CommunityDetail: Screen("community_detail")

    data object Community: Screen("community")

    data object More: Screen("more")
}