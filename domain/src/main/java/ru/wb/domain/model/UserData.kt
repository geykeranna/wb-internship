package ru.wb.domain.model

data class UserData(
    var id: String,
    var icon: String?,
    var firstName: String,
    var lastName: String?,
    val story: Boolean,
    var status: Boolean,
    var phone: String,
    var role: String?,
    var socialMedia: List<SocialMedia>
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
        )
    }
}
