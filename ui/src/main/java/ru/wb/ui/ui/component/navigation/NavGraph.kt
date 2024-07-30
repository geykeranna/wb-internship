package ru.wb.ui.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.ui.ui.screens.auth.phone.PhoneScreen
import ru.wb.ui.ui.screens.auth.pin.PinCodeScreen
import ru.wb.ui.ui.screens.community.community.CommunityScreen
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreen
import ru.wb.ui.ui.screens.events.active.ActiveEventsScreen
import ru.wb.ui.ui.screens.events.detail.DetailEventScreen
import ru.wb.ui.ui.screens.events.myevents.MyEventsScreen
import ru.wb.ui.ui.screens.more.MoreScreen
import ru.wb.ui.ui.screens.profile.edit.ProfileEditScreen
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreen
import ru.wb.ui.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    isAuth: Boolean = false,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SPLASH.route
    ){
        composable(route = Screen.EVENTS.route) {
            ActiveEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.EVENT_DETAIL.route + "/{id}") { stackEntry ->
            stackEntry.arguments?.getString("id")?.let {
                DetailEventScreen(
                    id = it,
                    navController = navController
                )
            }
        }

        composable(route = Screen.COMMUNITY.route) {
            CommunityScreen(
                navController = navController
            )
        }

        composable(route = Screen.COMMUNITY_DETAIL.route + "/{id}") { stackEntry ->
            stackEntry.arguments?.getString("id")?.let {
                DetailCommunityScreen(
                    id = it,
                    navController = navController,
                )
            }
        }

        composable(route = Screen.MORE.route) {
            MoreScreen(
                navController = navController
            )
        }

        composable(route = Screen.SPLASH.route) {
            SplashScreen(
                navController = navController,
                isAuth = isAuth
            )
        }

        composable(route = Screen.MY_EVENTS.route) {
            MyEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.PROFILE_VIEW.route) {
            ProfileViewScreen(
                navController = navController
            )
        }

        composable(route = Screen.PHONE.route) {
            PhoneScreen(
                navController = navController
            )
        }

        composable(route = Screen.PINCODE.route) {
            PinCodeScreen(
                navController = navController
            )
        }

        composable(route = Screen.PROFILE_EDIT.route) {
            ProfileEditScreen(
                navController = navController
            )
        }

        composable(route = Screen.PROFILE_FIRST_EDIT.route) {
            ProfileEditScreen(
                navController = navController,
                onBackClick = {
                    navController.navigate(Screen.PHONE.route) {
                        popUpTo(Screen.PROFILE_FIRST_EDIT.route) { inclusive = true }
                    }
                }
            )
        }
    }
}