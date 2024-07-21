package ru.wb.domain.model

data class UserData(
    var id: String?,
    var icon: String?,
    var firstName: String,
    var lastName: String,
    val story: Boolean?,
    var status: Boolean?,
    var phone: String?,
    var socialMedia: List<SocialMedia>
){
    companion object{
        val defaultObject = UserData(
            id = null,
            firstName = "",
            lastName = "",
            icon = "https://i.gifer.com/9NL8.gif",
            story = null,
            status = null,
            phone = "+71234567890",
            socialMedia = listOf()
        )
    }
}
