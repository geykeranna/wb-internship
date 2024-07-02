package ru.testtask.testapplication.data.model

import ru.testtask.testapplication.R

data class UserData(
    val id: Int,
    val icon: String?,
    val name: String,
    val story: Boolean,
    val status: Boolean,
    val phone: String,
    val socialMedia: List<SocialMedia>
){
    companion object{
        val shimmerData = UserData(
            id = 0,
            name = "User",
            icon = null,
            story = false,
            status = false,
            phone = "+7 999 999-99-99",
            socialMedia = listOf(
                SocialMedia(
                    name = "twitter",
                    icon = R.drawable.ic_twitter,
                    url = "https://twitter.com/"
                ),
                SocialMedia(
                    name = "instagram",
                    icon = R.drawable.ic_instagram,
                    url = "https://instagram.com/"
                ),
                SocialMedia(
                    name = "coolicon",
                    icon = R.drawable.ic_coolicon,
                    url = ""
                ),
                SocialMedia(
                    name = "facebook",
                    icon = R.drawable.ic_facebook,
                    url = "https://facebook.com/"
                ),
            )
        )
    }
}
