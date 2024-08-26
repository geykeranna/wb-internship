package ru.wb.ui.ui.component.navigation

enum class Screen(
    val route: String,
    val label: String
) {
    TEST (
        route = "test",
        label = "test",
    ),
    SPLASH (
        route = "splash",
        label = "Сплеш",
    ),
    EVENTS (
        route = "event",
        label = "Встречи"
    ),
    EVENT_DETAIL(
        route = "event_detail",
        label = "Экран детального просмотра"
    ),
    MEETING_DETAIL_FROM_COMMUNITY(
        route = "meeting_detail_from_community",
        label = "Экран детального просмотра"
    ),
    COMMUNITY_DETAIL (
        route = "community_detail",
        label = "Экран детального просмотра"
    ),
    COMMUNITY (
        route = "community",
        label = "Сообщества"
    ),
    MORE (
        route = "more",
        label = "Ещё"
    ),
    PROFILE_VIEW(
        route = "more_profile",
        label = "Профиль"
    ),
    PROFILE_EDIT (
        route = "more_profile_edit",
        label = "Профиль"
    ),
    PHONE (
        route = "first_number",
        label = "Введите номер телефона",
    ),
    PINCODE (
        route = "first_pin_code",
        label = "Введите код",
    ),
    PROFILE_FIRST_EDIT (
        route = "first_profile_edit",
        label = "Профиль",
    )
}