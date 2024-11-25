package ru.wb.domain.model

data class CountryCodes(
    val countryCode: String,
    val country: String,
    val flagIcon: String,
    val mask: String,
) {
    companion object {
        val defaultData = listOf(
            CountryCodes(
                country = "Russia",
                countryCode = "+7",
                flagIcon = "ru",
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Kazakhstan",
                countryCode = "+7",
                flagIcon = "kz",
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Armenia",
                countryCode = "+374",
                flagIcon = "am",
                mask = "00 000-000"
            ),
            CountryCodes(
                country = "USA",
                countryCode = "+1",
                flagIcon = "us",
                mask = "000 000 00-00"
            )
        )
    }
}
