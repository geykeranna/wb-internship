package ru.wb.domain.model

data class UserData(
    var id: String,
    var icon: String? = null,
    var firstName: String,
    var lastName: String? = null,
    val story: Boolean = false,
    val status: Boolean = false,
    var phone: String,
    var role: String? = null,
    var socialMedia: List<SocialMedia>,
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
