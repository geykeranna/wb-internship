package ru.wb.ui.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.ui.ui.screens.auth.onevent.Appointment
import ru.wb.ui.ui.screens.auth.phone.PhoneScreen
import ru.wb.ui.ui.screens.auth.pin.PinCodeScreen
import ru.wb.ui.ui.screens.community.community.CommunityScreen
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreen
import ru.wb.ui.ui.screens.events.detail.DetailEventScreen
import ru.wb.ui.ui.screens.events.main.MainEventsScreen
import ru.wb.ui.ui.screens.more.MoreScreen
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreen
import ru.wb.ui.ui.screens.splash.SplashScreen
import ru.wb.ui.ui.screens.test.Test
import ru.wb.ui.ui.screens.users.list.UsersListByEventScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    isAuth: Boolean = false,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.EVENTS.route
    ){
        composable(route = Screen.TEST.route) {
            Test()
        }

        composable(route = Screen.EVENTS.route) {
            MainEventsScreen(
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

        composable(route = Screen.MEETING_DETAIL_FROM_COMMUNITY.route + "/{id}") { stackEntry ->
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
                    idCommunity = it,
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

        composable(route = Screen.PROFILE_VIEW_OUTSIDE_DETAIL.route + "/{id}") { stackEntry ->
            stackEntry.arguments?.getString("id")?.let {
                ProfileViewScreen(
                    navController = navController,
                    idUser = it,
                )
            }
        }

        composable(route = Screen.PROFILE_VIEW_INSIDE_DETAIL.route) {
            ProfileViewScreen(
                navController = navController,
                idUser = "",
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

        composable(route = Screen.USER_LIST.route + "/{data}") { stackEntry ->
            stackEntry.arguments?.getString("data")?.let { data ->
                UsersListByEventScreen(
                    data = data,
                    navController = navController,
                )
            }
        }

        composable(route = Screen.APPOINTMENT.route + "/{data}") { stackEntry ->
            stackEntry.arguments?.getString("data")?.let { data ->
                val (idEvent, label) = data.split(" | ")
                Appointment(
                    idEvent = idEvent,
                    label = label,
                    navController = navController,
                )
            }
        }
    }
}