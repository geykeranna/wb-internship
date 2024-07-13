package ru.testtask.testapplication.ui.component.navigation

import android.content.res.Resources
import ru.testtask.testapplication.R

sealed class Screen(
    val route: String,
    val name: String
) {
    data object Splash: Screen(
        route = "splash_invisible",
        name = getString(R.string.label_screens_splash),
    )

    data object Events: Screen(
        route = "event",
        name = getString(R.string.label_screens_event)
    )

    data object EventsDetail: Screen(
        route = "event_detail",
        name = getString(R.string.label_screens_detail)
    )

    data object CommunityDetail: Screen(
        route = "community_detail",
        name = getString(R.string.label_screens_detail)
    )

    data object Community: Screen(
        route = "community",
        name = getString(R.string.label_screens_community)
    )

    data object More: Screen(
        route = "more",
        name = getString(R.string.label_screens_more)
    )

    data object ProfileView: Screen(
        route = "more_profile",
        name = getString(R.string.label_screens_profile)
    )

    data object ProfileEdit: Screen(
        route = "more_profile_edit",
        name = getString(R.string.label_screens_profile)
    )

    data object MyEvents: Screen(
        route = "more_my_meets",
        name = getString(R.string.label_screens_my_meets)
    )

    data object Phone: Screen(
        route = "first_number_invisible",
        name = getString(R.string.label_screens_phone),
    )

    data object PinCode: Screen(
        route = "first_pin_code_invisible",
        name = getString(R.string.label_screens_pin),
    )

    data object ProfileFirstEdit: Screen(
        route = "first_profile_edit_invisible",
        name = getString(R.string.label_screens_profile),
    )
}

fun getString(id: Int) = Resources.getSystem().getString(id)