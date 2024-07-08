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
        composable(route = Screen.Events.route) {
            ActiveEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.EventsDetail.route + "/{id}") { stackEntry ->
            val id = stackEntry.arguments?.getString("id")
            if (id != null) {
                DetailEventScreen(
                    id = id,
                    navController = navController
                )
            }
        }

        composable(route = Screen.Community.route) {
            CommunityScreen(
                navController = navController
            )
        }

        composable(route = Screen.CommunityDetail.route + "/{id}") { stackEntry ->
            val id = stackEntry.arguments?.getString("id")
            if (id != null) {
                DetailCommunityScreen(
                    navController = navController
                )
            }
        }

        composable(route = NavBar.More.route) {
//            MoreScreen()
            Task6()
        }
    }
}