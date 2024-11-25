package ru.wb.repository.data.api.model

internal data class Location(
    val id: String,
    val city: String,
    val address: String,
    val metro: String?,
    val icon: String?,
    val fullAddress: String,
    val coordinate: String?,
)