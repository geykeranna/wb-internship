package ru.testtask.testapplication.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.testtask.testapplication.ui.screens.events.ActiveEventsScreen
import ru.testtask.testapplication.ui.screens.events.MyEventsScreen
import ru.testtask.testapplication.ui.screens.profile.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavBar.Meeting.route
    ){
        composable(route = NavBar.Meeting.route) {
            ActiveEventsScreen()
        }

        composable(route = NavBar.Community.route) {
//            CommunityScreen() // Временно чтобы показать все экраны с дз
            MyEventsScreen()
        }

        composable(route = NavBar.More.route) {
            ProfileScreen()
        }
    }
}