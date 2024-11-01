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
            icon = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Moskwa_Metro_Line_2.svg/1024px-Moskwa_Metro_Line_2.svg.png",
            fullAddress = "Севкабель Порт, Кожевенная линия, 40",
            coordinate = null,
        )
    }
}
