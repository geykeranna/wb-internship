package ru.wb.ui.ui.component.navigation

enum class Screen(
    val route: String,
    val label: String
) {
    SPLASH (
        route = "splash",
        label = "Сплеш",
    ),
    EVENTS (
        route = "event",
        label = "Встречи"
    ),
    EVENT_DETAIL (
        route = "event_detail",
        label = "Экран детального просмотра"
    ),
    MEETING_DETAIL_FROM_COMMUNITY (
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
    PROFILE_VIEW_OUTSIDE_DETAIL (
        route = "profile_detail",
        label = "Профиль"
    ),
    PROFILE_VIEW_INSIDE_DETAIL (
        route = "profile_detail",
        label = "Профиль"
    ),
    EDIT_USER (
        route = "profile_detail",
        label = "Профиль"
    ),
    DELETE_PROFILE (
        route = "delete_profile",
        label = "Удаление профиля"
    ),
    SUBMIT_EVENT (
        route = "submit_going_event",
        label = "Подтверждение похода на событие"
    ),
    USER_LIST (
        route = "user_list_by_event",
        label = "Пользователи",
    ),
    APPOINTMENT_NAME (
        route = "appointment_name",
        label = "Авторизация",
    ),
    APPOINTMENT_PHONE (
        route = "appointment_phone",
        label = "Авторизация",
    ),
    APPOINTMENT_PIN (
        route = "appointment",
        label = "Авторизация",
    ),
    INTEREST (
        route = "interest",
        label = "Интересы",
    ),
}