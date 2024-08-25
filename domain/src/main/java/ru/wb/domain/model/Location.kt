package ru.wb.domain.model

data class Location(
    val city: String,
    val address: String,
    val metro: String?,
    val icon: String?
){
    companion object {
        val defaultObject = Location(
            city = "Mocква",
            address = "ул. Инженерная, 6",
            metro = "Приморская",
            icon = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Moskwa_Metro_Line_2.svg/1024px-Moskwa_Metro_Line_2.svg.png"
        )
    }
}
