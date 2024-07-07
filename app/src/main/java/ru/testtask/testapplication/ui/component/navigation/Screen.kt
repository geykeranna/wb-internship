package ru.testtask.testapplication.ui.component.navigation

sealed class Screen(val route: String) {
    data object Splash: Screen("splash")

    data object Events: Screen("event")

    data object Community: Screen("community")

    data object More: Screen("more")
}