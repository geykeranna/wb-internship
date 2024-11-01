package ru.wb.repository.data.api.model

internal data class Community (
    val id: String,
    val label: String,
    val subscribers: List<User>,
    val icon: String?,
    val description: String,
    val eventList: List<Event>,
    val isVerified: Boolean,
    val isSubscribed: Boolean,
    val tags: List<String>,
    val lastEvent: List<Event> = listOf()
)