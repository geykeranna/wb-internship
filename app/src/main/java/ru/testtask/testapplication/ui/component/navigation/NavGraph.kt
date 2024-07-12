package ru.testtask.testapplication.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.testtask.testapplication.ui.screens.auth.PhoneScreen
import ru.testtask.testapplication.ui.screens.auth.PinCodeScreen
import ru.testtask.testapplication.ui.screens.community.CommunityScreen
import ru.testtask.testapplication.ui.screens.community.DetailCommunityScreen
import ru.testtask.testapplication.ui.screens.events.ActiveEventsScreen
import ru.testtask.testapplication.ui.screens.events.DetailEventScreen
import ru.testtask.testapplication.ui.screens.events.MyEventsScreen
import ru.testtask.testapplication.ui.screens.more.MoreScreen
import ru.testtask.testapplication.ui.screens.profile.ProfileEditScreen
import ru.testtask.testapplication.ui.screens.profile.ProfileViewScreen
import ru.testtask.testapplication.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    isAuth: Boolean = false,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(route = Screen.Events.route) {
            ActiveEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.EventsDetail.route + "/{id}") { stackEntry ->
            val id = stackEntry.arguments?.getString("id")
            if (!id.isNullOrEmpty()) {
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
            if (!id.isNullOrEmpty()) {
                DetailCommunityScreen(
                    navController = navController
                )
            }
        }

        composable(route = Screen.More.route) {
            MoreScreen(
                navController = navController
            )
        }

        composable(route = Screen.Splash.route) {
            SplashScreen(
                navController = navController,
                isAuth = isAuth
            )
        }

        composable(route = Screen.MyEvents.route) {
            MyEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.ProfileView.route) {
            ProfileViewScreen(
                navController = navController
            )
        }

        composable(route = Screen.Phone.route) {
            PhoneScreen(
                navController = navController
            )
        }

        composable(route = Screen.PinCode.route + "/{number}") { stackEntry ->
            val number = stackEntry.arguments?.getString("number")
            if (!number.isNullOrEmpty()) {
                PinCodeScreen(
                    navController = navController,
                    phone = number
                )
            }
        }

        composable(route = Screen.ProfileEdit.route) {
            ProfileEditScreen(
                navController = navController
            )
        }

        composable(route = Screen.ProfileFirstEdit.route) {
            ProfileEditScreen(
                navController = navController,
                onBackClick = {
                    navController.navigate(Screen.Phone.route) {
                        popUpTo(Screen.ProfileFirstEdit.route) { inclusive = true }
                    }
                }
            )
        }

    }
}