package ru.wb.domain.model

data class UserData(
    val id: String,
    val icon: String? = null,
    val firstName: String,
    val lastName: String? = null,
    val story: Boolean = false,
    val status: Boolean = false,
    val phone: String,
    val role: String? = null,
    val socialMedia: List<SocialMedia>,
    val description: String? = null,
){
    companion object{
        val defaultObject = UserData(
            id = "",
            firstName = "Anna",
            lastName = "",
            icon = "",
            story = false,
            status = false,
            phone = "",
            socialMedia = listOf(),
            role = "Developer",
            description = ""
        )
    }
}
