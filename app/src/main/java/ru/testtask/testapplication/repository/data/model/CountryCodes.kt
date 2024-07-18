package ru.testtask.testapplication.presentation.data.model

import ru.testtask.testapplication.R

data class CountryCodes(
    val countryCode: String,
    val country: String,
    val flagIcon: Int,
    val mask: String
) {
    companion object {
        val shimmerData = listOf(
            CountryCodes(
                country = "Russia",
                countryCode = "+7",
                flagIcon = R.drawable.flag_russia,
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Kazakhstan",
                countryCode = "+7",
                flagIcon = R.drawable.flag_kz,
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Armenia",
                countryCode = "+374",
                flagIcon = R.drawable.flag_armenia,
                mask = "00 000-000"
            ),
            CountryCodes(
                country = "USA",
                countryCode = "+1",
                flagIcon = R.drawable.flag_usa,
                mask = "000 000 00-00"
            )
        )
    }
}
