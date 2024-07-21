package ru.wb.domain.model

data class CountryCodes(
    val countryCode: String,
    val country: String,
    val flagIcon: String,
    val mask: String
) {
    companion object {
        val shimmerData = listOf(
            CountryCodes(
                country = "Russia",
                countryCode = "+7",
                flagIcon = "https://www.countryflags.com/wp-content/uploads/russia-flag-png-large.png",
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Kazakhstan",
                countryCode = "+7",
                flagIcon = "https://www.countryflags.com/wp-content/uploads/kazakhstan-flag-png-large.png",
                mask = "000 000 00-00"
            ),
            CountryCodes(
                country = "Armenia",
                countryCode = "+374",
                flagIcon = "https://www.countryflags.com/wp-content/uploads/flag-jpg-xl-8-1024x512.jpg",
                mask = "00 000-000"
            ),
            CountryCodes(
                country = "USA",
                countryCode = "+1",
                flagIcon = "https://www.countryflags.com/wp-content/uploads/united-states-of-america-flag-png-large.png",
                mask = "000 000 00-00"
            )
        )
    }
}
