package ru.testtask.testapplication.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.testtask.testapplication.ui.screens.community.CommunityScreen
import ru.testtask.testapplication.ui.screens.community.DetailCommunityScreen
import ru.testtask.testapplication.ui.screens.events.ActiveEventsScreen
import ru.testtask.testapplication.ui.screens.events.DetailEventScreen
import ru.testtask.testapplication.ui.screens.more.MoreScreen
import ru.testtask.testapplication.ui.screens.tasks.Task6

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavBar.Event.route
    ){
        composable(route = NavBar.Event.route) {
//            ActiveEventsScreen()
            DetailEventScreen()
        }

        composable(route = NavBar.Community.route) {
//            CommunityScreen()
            DetailCommunityScreen()
        }

        composable(route = NavBar.More.route) {
//            MoreScreen()
            Task6()
        }
    }
}