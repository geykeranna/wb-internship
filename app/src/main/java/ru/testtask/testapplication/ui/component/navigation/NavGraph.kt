package ru.testtask.testapplication.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.testtask.testapplication.ui.screens.community.CommunityScreen
import ru.testtask.testapplication.ui.screens.events.ActiveEventsScreen
import ru.testtask.testapplication.ui.screens.more.MoreScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavBar.Event.route
    ){
        composable(route = NavBar.Event.route) {
            ActiveEventsScreen()
        }

        composable(route = NavBar.Community.route) {
            CommunityScreen()
        }

        composable(route = NavBar.More.route) {
            MoreScreen()
        }
    }
}