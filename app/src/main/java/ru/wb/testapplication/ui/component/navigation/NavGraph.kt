package ru.wb.testapplication.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.testapplication.ui.screens.auth.phone.PhoneScreen
import ru.wb.testapplication.ui.screens.auth.pin.PinCodeScreen
import ru.wb.testapplication.ui.screens.community.community.CommunityScreen
import ru.wb.testapplication.ui.screens.community.detail.DetailCommunityScreen
import ru.wb.testapplication.ui.screens.events.active.ActiveEventsScreen
import ru.wb.testapplication.ui.screens.events.detail.DetailEventScreen
import ru.wb.testapplication.ui.screens.events.myevents.MyEventsScreen
import ru.wb.testapplication.ui.screens.more.MoreScreen
import ru.wb.testapplication.ui.screens.profile.edit.ProfileEditScreen
import ru.wb.testapplication.ui.screens.profile.view.ProfileViewScreen
import ru.wb.testapplication.ui.screens.splash.SplashScreen

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
            stackEntry.arguments?.getString("id")?.let {
                DetailEventScreen(
                    id = it,
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
            stackEntry.arguments?.getString("id")?.let {
                DetailCommunityScreen(
                    id = it,
                    navController = navController,
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

        composable(route = Screen.PinCode.route) {
            PinCodeScreen(
                navController = navController
            )
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