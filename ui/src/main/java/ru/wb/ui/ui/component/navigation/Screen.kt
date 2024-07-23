package ru.wb.ui.ui.component.navigation

sealed class Screen(
    val route: String,
    val name: String
) {

    data object Splash: Screen(
        route = "splash",
        name = "Сплеш",
    )

    data object Events: Screen(
        route = "event",
        name = "Встречи"
    )

    data object EventsDetail: Screen(
        route = "event_detail",
        name = "Экран детального просмотра"
    )

    data object CommunityDetail: Screen(
        route = "community_detail",
        name = "Экран детального просмотра"
    )

    data object Community: Screen(
        route = "community",
        name = "Сообщества"
    )

    data object More: Screen(
        route = "more",
        name = "Ещё"
    )

    data object ProfileView: Screen(
        route = "more_profile",
        name = "Профиль"
    )

    data object ProfileEdit: Screen(
        route = "more_profile_edit",
        name = "Профиль"
    )

    data object MyEvents: Screen(
        route = "more_my_meets",
        name = "Мои встречи"
    )

    data object Phone: Screen(
        route = "first_number",
        name = "Введите номер телефона",
    )

    data object PinCode: Screen(
        route = "first_pin_code",
        name = "Введите код",
    )

    data object ProfileFirstEdit: Screen(
        route = "first_profile_edit",
        name = "Профиль",
    )
}