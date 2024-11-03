package ru.wb.ui.ui.component.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wb.ui.ui.screens.auth.onevent.name.AppointmentName
import ru.wb.ui.ui.screens.auth.onevent.phone.AppointmentPhone
import ru.wb.ui.ui.screens.auth.onevent.pin.AppointmentPin
import ru.wb.ui.ui.screens.community.community.CommunityScreen
import ru.wb.ui.ui.screens.community.detail.DetailCommunityScreen
import ru.wb.ui.ui.screens.events.detail.DetailEventScreen
import ru.wb.ui.ui.screens.events.main.MainEventsScreen
import ru.wb.ui.ui.screens.events.submit.SubmitEventsScreen
import ru.wb.ui.ui.screens.more.MoreScreen
import ru.wb.ui.ui.screens.profile.delete.DeleteProfileViewScreen
import ru.wb.ui.ui.screens.profile.view.ProfileViewScreen
import ru.wb.ui.ui.screens.startscreens.interests.InterestsScreen
import ru.wb.ui.ui.screens.startscreens.splash.SplashScreen
import ru.wb.ui.ui.screens.users.list.UsersListByEventScreen

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
            MainEventsScreen(
                navController = navController
            )
        }

        composable(route = Screen.DELETE_PROFILE.route) {
            DeleteProfileViewScreen(
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

        composable(route = Screen.INTEREST.route + "/{id}") { stackEntry ->
            stackEntry.arguments?.getString("id")?.let { id ->
                InterestsScreen(
                    idUser = id,
                    navController = navController,
                )
            }
        }

        composable(route = Screen.INTEREST.route) {
            InterestsScreen(
                navController = navController,
            )
        }

        composable(route = Screen.SUBMIT_EVENT.route + "/{label}/{id}") { stackEntry ->
            stackEntry.arguments?.getString("label")?.let { label ->
                val idUser = stackEntry.arguments?.getString("label") ?: ""
                SubmitEventsScreen(
                    label = label,
                    id = idUser,
                    navController = navController,
                )
            }
        }

        composable(route = Screen.USER_LIST.route + "/{data}") { stackEntry ->
            stackEntry.arguments?.getString("data")?.let { data ->
                UsersListByEventScreen(
                    data = data,
                    navController = navController,
                )
            }
        }

        composable(route = Screen.APPOINTMENT_NAME.route + "/{eventId}/{label}") { stackEntry ->
            stackEntry.arguments?.getString("eventId")?.let { eventId ->
                val label = stackEntry.arguments?.getString("label")
                when {
                    !label.isNullOrEmpty() -> {
                        AppointmentName(
                            idEvent = eventId,
                            label = label,
                            navController = navController,
                        )
                    }
                }
            }
        }
        composable(route = Screen.APPOINTMENT_PIN.route + "/{eventId}/{label}") { stackEntry ->
            stackEntry.arguments?.getString("eventId")?.let { eventId ->
                val label = stackEntry.arguments?.getString("label")
                when {
                    !label.isNullOrEmpty() -> {
                        AppointmentPin(
                            idEvent = eventId,
                            label = label,
                            navController = navController,
                        )
                    }
                }
            }
        }
        composable(route = Screen.APPOINTMENT_PHONE.route + "/{eventId}/{label}") { stackEntry ->
            stackEntry.arguments?.getString("eventId")?.let { eventId ->
                val label = stackEntry.arguments?.getString("label")
                when {
                    !label.isNullOrEmpty() -> {
                        AppointmentPhone(
                            idEvent = eventId,
                            label = label,
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}