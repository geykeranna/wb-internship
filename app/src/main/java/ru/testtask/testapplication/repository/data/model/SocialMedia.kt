package ru.testtask.testapplication.repository.data.model

import ru.testtask.testapplication.R

data class SocialMedia(
    val name: String,
    val icon: Int?,
    val url: String
) {
    companion object{
        val shimmerData = SocialMedia(
            name = "twitter",
            icon = R.drawable.ic_twitter,
            url = "https://twitter.com/"
        )
    }
}
