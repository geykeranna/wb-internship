package ru.testtask.testapplication.data.model

import ru.testtask.testapplication.R

data class CountryCodes(
    val countryCode: String,
    val country: String,
    val flagIcon: Int
) {
    companion object {
        val shimmerData = listOf(
            CountryCodes(
                country = "Russia",
                countryCode = "+7",
                flagIcon = R.drawable.flag_russia),
            CountryCodes(
                country = "Kazakhstan",
                countryCode = "+7",
                flagIcon = R.drawable.flag_kz),
            CountryCodes(
                country = "Armenia",
                countryCode = "+374",
                flagIcon = R.drawable.flag_armenia
            ),
            CountryCodes(
                country = "USA",
                countryCode = "+1",
                flagIcon = R.drawable.flag_usa
            )
        )
    }
}
