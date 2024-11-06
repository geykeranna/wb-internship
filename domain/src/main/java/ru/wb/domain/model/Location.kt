package ru.wb.domain.model

data class Location(
    val id: String,
    val city: String,
    val address: String,
    val metro: String?,
    val icon: String?,
    val fullAddress: String,
    val coordinate: String?,
){
    companion object {
        val defaultObject = Location(
            id = "",
            city = "Mocква",
            address = "ул. Инженерная, 6",
            metro = "Приморская",
            icon = null,
            fullAddress = "Севкабель Порт, Кожевенная линия, 40",
            coordinate = null,
        )
    }
}
