package ru.wb.domain.model

data class UserData(
    var id: String,
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
            id = "",
            firstName = "",
            lastName = "",
            icon = "",
            story = null,
            status = null,
            phone = "",
            socialMedia = listOf()
        )
    }
}
