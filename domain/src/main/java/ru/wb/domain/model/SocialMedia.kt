package ru.wb.domain.model

data class SocialMedia(
    val name: String,
    val baseUrl: String,
    val url: String,
    val id: String,
) {
    companion object{
        val defaultObject = SocialMedia(
            id = "1",
            name = "telegram",
            baseUrl = "https://t.me/",
            url = ""
        )
    }
}
