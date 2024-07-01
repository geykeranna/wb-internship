package ru.testtask.testapplication.data.modal

data class SocialMedia(
    val name: String,
    val icon: Int?,
    val url: String?
) {
    companion object{
        val shimmerData = SocialMedia(
            name = "",
            icon = null,
            url = null
        )
    }
}
